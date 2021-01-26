 import org.rosuda.REngine.REXPMismatchException;
 import org.rosuda.REngine.Rserve.RConnection;
 import org.rosuda.REngine.Rserve.RserveException;
 
 public class Rcall {
 
     public static void main(String a[]) {
         RConnection connection = null;
 
         try {
             /* Create a connection to Rserve instance running
              * on default port 6311
              */
             connection = new RConnection();
 
             String vector = "c(1,2,3,4)";
             connection.eval("sumVal=sum(" + vector + ")");
             double mean = connection.eval("sumVal").asDouble();
             System.out.println("The sum is=" + mean);
             String  nm[] = connection.eval("rnorm(100,0,1)").asStrings();
             
             
             for (short t=0; t < nm.length; t++){
            	 System.out.println(t + " = " + nm[t] );
             }
             
             
         } catch (RserveException e) {
             e.printStackTrace();
         } catch (REXPMismatchException e) {
             e.printStackTrace();
         }finally{
             connection.close();
         }
     }
 }