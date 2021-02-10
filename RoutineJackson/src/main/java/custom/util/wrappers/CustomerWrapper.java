/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom.util.wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 *
 * @author SharpSchnitzel
 */
public class CustomerWrapper {
    
    private List<Map<String, String>> list;
    
    public CustomerWrapper () {
        this.list = new ArrayList<>();
    }
    
    public CustomerWrapper (List<Map<String, String>> list) {
        this();
        this.list = list;
    }
    
    public void printCustomers() {
        IntStream.range(0, this.list.size()).forEach(_idx -> {
            System.out.println("-- Customer #" + (_idx + 1) + " --");
            this.list.get(_idx).entrySet().forEach(_entry -> {
                System.out.println("| " + _entry.getKey().substring(0,1).toUpperCase() + _entry.getKey().substring(1).replaceAll("_", " ") + " is " + _entry.getValue());
            });
            System.out.println("------ EOL ------\n");
        });
    }
    
    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(List<Map<String, String>> list) {
        this.list = list;
    }
}
