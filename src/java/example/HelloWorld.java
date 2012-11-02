/*
 * $Id: HelloWorld.template,v 1.2 2008-03-27 05:47:21 ub3rsold4t Exp $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package example;

import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 * <code>Set welcome message.</code>
 */
public class HelloWorld extends ActionSupport implements ServletRequestAware{
private HttpServletRequest servletRequest;
    @Override
    public String execute() throws Exception {
        // Create file 
        String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
        FileWriter fstream = new FileWriter(filePath+"hola.xhtml");
        BufferedWriter out = new BufferedWriter(fstream);
        out.write("<!DOCTYPE html PUBLIC \"-//W3C/DTD XHTML+Voice 1.0/EN\" \"xhtml+voice.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"      xmlns:ev=\"http://www.w3.org/2001/xml-events\"><head>  <title>Grammar</title>  <style type=\"text/css\">     #colorSample {border: thick solid; background: #EEC; font-size: 1.27em; padding: 0.1em}</style>  <form xmlns=\"http://www.w3.org/2001/vxml\" id=\"grammar\"><field name=\"Option\">   <grammar><![CDATA[        #JSGF V1.0;        grammar color;        public <color> = Next|before; ]]>      </grammar>   	  <prompt>	  A cock was once strutting up and down the farmyard among the hens when suddenly he espied something shinning amid the straw.\"Ho! ho! ho!\" quoth he, \"that's for me,\" and soon rooted it out from beneath the straw. What did it turn out to be but a Pearl that by some chance had been lost in the yard?\"You may be a treasure,\" quoth Master Cock, \"to men that prize you, but for me I would rather have a single barley-corn than a peck of pearls.\"Precious things are for those that can prize them.</prompt>	</field>	<filled> <!-- Give aural and visual feedback -->	  <assign name=\"callToActionscript(Option)\" expr=\"Option\"/> 	</filled>  </form>  <script type=\"text/javascript\" ev:event=\"load\" ev:observer=\"bod_id\"></script>    <script ev:event=\"DOMActivate\" type=\"text/javascript\" >			function load(){				document.getElementById('1').style.visibility='hidden'; 				document.getElementById('1').click();			}		function getFlashMovie(movieName) {				var isIE = navigator.appName.indexOf(\"Microsoft\") != -1;				return (isIE) ? window[movieName] : document[movieName];			}			function sendToJavaScript(option){				document.getElementById('1').click();			}			function callToActionscript(str) {				alert(\"Tu dijiste \" + str);			}</script></head><body onload=\"load()\">  <h1>Lecture</h1>  <button ev:event=\"click\" ev:handler=\"#grammar\" name=\"1\" id=\"1\"></button>  <p>A cock was once strutting up and down the farmyard among the hens when suddenly he espied something shinning amid the straw.\"Ho! ho! ho! ho! ho!\" quoth he, \"that's for me,\" and soon rooted it out from beneath the straw. What did it turn out to be but a Pearl that by some chance had been lost in the yard?\"You may be a treasure,\" quoth Master Cock, \"to men that prize you, but for me I would rather have a single barley-corn than a peck of pearls.\"Precious things are for those that can prize them.</p></body></html>");
        out.close();
        System.out.println("archivo creado");
        return "SUCCESS";
    }
    /**
     * Provide default valuie for Message property.
     */
    public static final String MESSAGE = "HelloWorld.message";
    /**
     * Field for Message property.
     */
    private String message;

    /**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on HelloWorld page.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.servletRequest = hsr;
    }
}
