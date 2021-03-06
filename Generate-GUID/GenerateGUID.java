//package test1;

//Some parts of this code have been automatically generated - copyright for generic plug-in procedure reserved by Ingenieurbuero David Fischer AG, Switzerland.
//Copyright for manual written code belongs to <your name>, <your company>, <your country>
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.LoadtestPluginInterface;
import dfischer.utils.LoadtestPluginFixedUserInputField;
import dfischer.utils.LogVector;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.PerformanceData;
import dfischer.utils.CookieHandler;
import dfischer.utils.HttpTestURL;

/**
* Load test add-on module.
*/
public class GenerateGUID implements LoadtestPluginInterface
{
 private String guid_format = "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx";        // input parameter #1 - label "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx" or "1xxxxxxx-3xxx-5xxx-8xxx-xxxxxxxxxxx9"
 
 private String guid_output = "";        // output parameter #1 - label "guid output"
 
 private LogVector logVector = null;        // internal log vector - use logVector.log(<String>) to write log data
 
 
 // ----------------------------------------------------------------------------
 // PART 1: var handler GUI definition and load test integration
 //
 // Note: automatically generated - no manual programming required for this part
 // ----------------------------------------------------------------------------
 
 
 public int getPluginType()
 {
     return GenericPluginInterface.TYPE_LOADTEST_EXEC;
 }
 
 
 public String getPluginName()
 {
     return "Generate GUID";
 }
 
 
 public String getPluginDescription()
 {
     return "Plugin to generate globally unique ID. Replaces x with random hex digit so you can set a static value instead of x (like 1FABxxxx-3xxx-5xxx-8xxx-xxxxxxxxxxx9).\n\n";
 }
 
 
 public int getAllowedConstructScope()
 {
     return LoadtestPluginInterface.EXEC_SCOPE_NOT_FIXED;
 }
 
 
 public int getAllowedExecScope()
 {
     return LoadtestPluginInterface.EXEC_SCOPE_NOT_FIXED;
 }
 
 
 public int getAllowedExecOrder()
 {
     return LoadtestPluginInterface.EXEC_ORDER_NOT_FIXED;
 }
 
 
 public boolean allowMultipleUsage()
 {
     return true;
 }
 
 
 public String[] getInputParameterLabels()
 {
     String[] labels = new String[1];
     labels[0] = "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx";
     return labels;
 }
 
 
 public LoadtestPluginFixedUserInputField[] getFixedUserInputFields()
 {
     return null;
 }
 
 
 public int allowOptionalInputParameter()
 {
     return 0;        // optional input parameters starting from parameter #1
 }
 
 
 public String[] getOutputParameterLabels()
 {
     String[] labels = new String[1];
     labels[0] = "guid output";
     return labels;
 }
 
 
 public int allowOptionalOutputParameter()
 {
     return -1;        // all output parameters required
 }
 
 
 public LogVector getLogVector()
 {
     return logVector;
 }
 
 
 
 // ----------------------------------------------------------------------------
 // PART 2: runtime behavior / plug-in functionality
 //
 // This part requires manual programming (see sample code section below)
 // ----------------------------------------------------------------------------
 
 
 /**
  * Initialize plug-in at start of load test.
  */
 public void construct(Object context)
 {
     // LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
 }
 
 
 /**
  * Transfer input parameter before execute() is called.
  *
  * input parameter #1: (String) guid_format / default value = '' / label "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx" / [optional]
  *
  * Note: all input parameters are always converted from strings.
  */
 public void setInputParameter(int parameterNumber, Object parameterValue)
 {
     switch (parameterNumber)
     {
         case 0:
             guid_format = (String) parameterValue;
             break;
         default:
             break;
     }
 }
 
 
 /**
  * Execute plug-in .
  *
  * Intrinsic plug-in implementation.
  */
 public void execute(Object context)
 {
     logVector = new LogVector();
     LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;

     for(char ch : guid_format.toCharArray()){
    	 if(ch == 'x')
    		 guid_output += Integer.toHexString((int) (Math.random()*16));
    	 else
    		 guid_output += ch;
     }
    	     
 }
 
 
 /**
  * Return plug-in output parameter.
  *
  * output parameter #1: (String) guid_output / default value = '' / label "guid output"
  *
  * Note: all output parameters are always converted to strings.
  */
 public Object getOutputParameter(int parameterNumber)
 {
     switch (parameterNumber)
     {
         case 0:
             return guid_output;
         default:
             return null;
     }
 }
 
 
 /**
  * Finalize plug-in at end of load test.
  */
 public void deconstruct(Object context)
 {
     // LoadtestPluginContext pluginContext = (LoadtestPluginContext) context;
 }
 
 
 
 // ----------------------------------------------------------------------------
 // PART 3: stand-alone test utility - optional - used for plug-in development
 // ----------------------------------------------------------------------------
 
 /*
 public static void main(String[] args)
 {
     try
     {
         // vvv --- sample code --- vvv
         
         GenerateGUID plugin = new GenerateGUID();
         plugin.construct(null);
         plugin.setInputParameter(0, "feedxxxx-xxxx-fxxx-xxxx-xxxxxxxxxxxx");
         plugin.execute(null);
         System.out.println(plugin.getOutputParameter(0));
         plugin.deconstruct(null);
         
         // ^^^ --- sample code --- ^^^
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
 }
*/


}    // end of class
