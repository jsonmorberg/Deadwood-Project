package GUI;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;

/** Class that parses through both Cards.XMl and Board.XML to generate the rooms, scenes, and roles required to play the game */

public class Parser {

    //creates doc object to parse through the XMl files
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

    //Parses and creates an ArrayList of Scenes using Cards.XML
    public ArrayList<SceneCard> readCardData(Document d) {

        Element root = d.getDocumentElement();

        ArrayList<SceneCard> scenes = new ArrayList<SceneCard>();


        NodeList cards = root.getElementsByTagName("card");
        for (int i = 0; i < cards.getLength(); i++) {

            String sceneName = "";
            String sceneBudget = "";
            String sceneNum = "";
            String sceneJpg = "";
            String description = "";

            Node card = cards.item(i);
            sceneName = card.getAttributes().getNamedItem("name").getNodeValue();
            sceneBudget = card.getAttributes().getNamedItem("budget").getNodeValue();
            sceneJpg = card.getAttributes().getNamedItem("img").getNodeValue();

            NodeList children = card.getChildNodes();
            ArrayList<Role> roles = new ArrayList<Role>();
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
            scenes.add(new SceneCard(Integer.parseInt(sceneNum), sceneName, description, Integer.parseInt(sceneBudget), roles, sceneJpg));
        }
        return scenes;
    }

    //Parses and creates an ArrayList of MovieSets using Board.XML including the roles required
    public ArrayList<MovieSet> readBoardData(Document d) {

        Element root = d.getDocumentElement();

        ArrayList<MovieSet> movieSets = new ArrayList<MovieSet>();


        NodeList sets = root.getElementsByTagName("set");
        for (int i = 0; i < sets.getLength(); i++) {


            String setName = "";
            String takeNum = "";

            Node set = sets.item(i);
            setName = set.getAttributes().getNamedItem("name").getNodeValue();

            NodeList children = set.getChildNodes();
            ArrayList<Role> roles = new ArrayList<Role>();

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
        }
        return movieSets;
    }
}