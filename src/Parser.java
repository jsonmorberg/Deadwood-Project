import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class Parser {

    public Document getDocFromFile(String filename) throws ParserConfigurationException {
        {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = null;

            try {
                doc = db.parse(filename);
            } catch (Exception ex) {
                System.out.println("XML parse failure");
                ex.printStackTrace();
            }
            return doc;
        }

    }

    public ArrayList<Scene> readCardData(Document d) {

        Element root = d.getDocumentElement();

        ArrayList<Scene> scenes = new ArrayList<Scene>();
        ArrayList<Role> roles = new ArrayList<Role>();

        NodeList cards = root.getElementsByTagName("card");
        for (int i = 0; i < cards.getLength(); i++) {

            String sceneName = "";
            String sceneBudget = "";
            String sceneNum = "";
            String description = "";

            Node card = cards.item(i);
            sceneName = card.getAttributes().getNamedItem("name").getNodeValue();
            sceneBudget = card.getAttributes().getNamedItem("budget").getNodeValue();

            NodeList children = card.getChildNodes();

            for (int j = 0; j < children.getLength(); j++) {

                Node sub = children.item(j);

                if ("scene".equals(sub.getNodeName())) {
                    sceneNum = sub.getAttributes().getNamedItem("number").getNodeValue();
                    description = sub.getTextContent();

                } else if ("part".equals(sub.getNodeName())) {
                    String partName = sub.getAttributes().getNamedItem("name").getNodeValue();
                    String partLevel = sub.getAttributes().getNamedItem("level").getNodeValue();

                    NodeList lines = sub.getChildNodes();
                    Node line = lines.item(3);
                    String partLine = line.getTextContent();

                    roles.add(new Role(partName, partLine, false, Integer.parseInt(partLevel)));
                }
            }
            scenes.add(new Scene(Integer.parseInt(sceneNum), sceneName, description, Integer.parseInt(sceneBudget), roles));
            roles.clear();
        }
        return scenes;
    }

    public ArrayList<MovieSet> readBoardData(Document d) {

        Element root = d.getDocumentElement();

        ArrayList<MovieSet> movieSets = new ArrayList<MovieSet>();
        ArrayList<Role> roles = new ArrayList<Role>();

        NodeList sets = root.getElementsByTagName("set");
        for (int i = 0; i < sets.getLength(); i++) {


            String setName = "";
            String takeNum = "";

            Node set = sets.item(i);
            setName = set.getAttributes().getNamedItem("name").getNodeValue();

            NodeList children = set.getChildNodes();

            for (int j = 0; j < children.getLength(); j++) {

                Node sub = children.item(j);

                if ("takes".equals(sub.getNodeName())) {
                    NodeList takes = sub.getChildNodes();
                    Node take = takes.item(1);
                    takeNum = take.getAttributes().getNamedItem("number").getNodeValue();

                } else if ("parts".equals(sub.getNodeName())) {

                    NodeList parts = sub.getChildNodes();

                    for(int k = 0; k < parts.getLength(); k++){

                        Node part = parts.item(k);

                        if("part".equals(part.getNodeName())){
                            String partName = part.getAttributes().getNamedItem("name").getNodeValue();
                            String partLevel = part.getAttributes().getNamedItem("level").getNodeValue();

                            NodeList lines = part.getChildNodes();
                            Node line = lines.item(3);
                            String partLine = line.getTextContent();

                            roles.add(new Role(partName, partLine, true, Integer.parseInt(partLevel)));
                        }
                    }
                }
            }
            movieSets.add(new MovieSet(setName, Integer.parseInt(takeNum), roles));
            roles.clear();
        }
        return movieSets;
    }
}