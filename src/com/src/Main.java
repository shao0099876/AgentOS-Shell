package com.src;

import com.src.object.Scene;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        if(args.length==0){
            System.exit(0);
        }
        for(int i=0;i<args.length;i++){
            if(args[i].equals("--network-enable")){
                Global.network_enable=true;
                Global.network_port=Integer.parseInt(args[++i]);
            } else{
                Global.script_name=args[i];
                Global.script_root=args[++i];
            }
        }
        try {
            readScript(Global.script_root+"/"+Global.script_name+".aosmanifest");
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        //test
        for(Scene i:Global.sceneArrayList){
            System.out.println(i.id+" "+i.name);
        }
    }
    private static void readScript(String fileName) throws ParserConfigurationException, IOException, SAXException {
        File scriptFile=new File(fileName);
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(scriptFile);
        Global.sceneArrayList= new ArrayList<>();
        NodeList sceneList=document.getElementsByTagName("scene");
        for(int i=0;i<sceneList.getLength();i++){
            Node now=sceneList.item(i);
            if(now.getNodeType()==Node.ELEMENT_NODE){
                Scene scene=new Scene();
                Element nowElement=(Element) now;
                scene.id=Integer.parseInt(nowElement.getElementsByTagName("id").item(0).getTextContent().trim());
                scene.name=nowElement.getElementsByTagName("name").item(0).getTextContent().trim();
                Global.sceneArrayList.add(scene);
            }
        }
    }
}
