package com.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class MikeDroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
        	System.out.println("Calcing...");
            CPQ cpq = new CPQ();
            cpq.setClientID("A100");
            cpq.setCost(5.25);
            kSession.insert(cpq);
            kSession.fireAllRules();
            System.out.println("My Retail Price is: "+ cpq.getRetailPrice()); 
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
