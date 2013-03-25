

package cppParser.utils;

import cppParser.Log;
import cppParser.utils.parameter.ParameterToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomi
 */
public class FunctionCall {
    public static final int UNKNOWN=0, MEMBER=1, INHERITED=2, FOREIGN=3; 
    /*These are ownerTypes 
     * UNKNOWN owner is not properly determined (yet)
     * MEMBER function of currently analyzed class
     * INHERITED inherited function
     * FOREIGN function is not inherited from parent class and it's not not member of currently analyzed class
     */

    

    
    
    public int ownerType=0;
    public List<ParameterToken> owners=null;
   
    public String name=null;
    public List<List<ParameterToken>> parameters=new ArrayList<>();

    public FunctionCall(String name) {
        this.name=name;
    }

    public FunctionCall(List<ParameterToken> owners,String name) {
        this.owners=owners;
        this.name=name;
    }
    
    public FunctionCall(List<ParameterToken> owners,String name, List<List<ParameterToken>> parameters) {
        this.owners=owners;
        this.name=name;
        this.parameters=parameters;
    }
    public FunctionCall(String name, List<List<ParameterToken>> parameters) {
        this.name=name;
        this.parameters=parameters;
    }
    
    @Override
    public String toString(){
        String owner="", params="";
        if(owners!=null){
            if(!owners.isEmpty())
            for(ParameterToken s:owners)
                owner+=s.toString();
        }
        if(parameters!=null){
            for(int i=0;i<parameters.size();i++){
                if(i>0)
                    params+=", ";
                for(ParameterToken pt:parameters.get(i))
                    params+=pt.toString();
            }
        }
        return (owner+name+"("+params+")");
        
    }
    
    

    
}
