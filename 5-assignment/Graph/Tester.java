import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Tester{
	WeightedGraph<String> myGraph = new WeightedGraph<String>();

	public static void main(String[] args){
		System.out.println("Welcome to the graph tester class!");

		WeightedGraph<String> graph = new WeightedGraph<String>();
        String s0 = new String("Atlanta   ");
        String s1 = new String("Austin    ");
        String s2 = new String("Chicago   ");
        String s3 = new String("Dallas    ");
        String s4 = new String("Denver    ");
        String s5 = new String("Houston   ");
        String s6 = new String("Washington");


        System.out.println("Connecting to Google Maps to get distance information...");
        graph.addVertex(s0);
        graph.addVertex(s1);
        graph.addVertex(s2);
        graph.addVertex(s3);
        graph.addVertex(s4);
        graph.addVertex(s5);
        graph.addVertex(s6);

        graph.addEdge(s0, s5, getDistance(s0, s5));
        graph.addEdge(s0, s6, getDistance(s0, s6));
        graph.addEdge(s1, s3, getDistance(s1, s3));
        graph.addEdge(s1, s5, getDistance(s1, s5));
        graph.addEdge(s2, s4, getDistance(s2, s4));
        graph.addEdge(s3, s1, getDistance(s3, s1));
        graph.addEdge(s3, s2, getDistance(s3, s2));
        graph.addEdge(s3, s4, getDistance(s3, s4));
        graph.addEdge(s4, s0, getDistance(s4, s0));
        graph.addEdge(s4, s2, getDistance(s4, s2));
        graph.addEdge(s5, s0, getDistance(s5, s0));
        graph.addEdge(s6, s0, getDistance(s6, s0));
        graph.addEdge(s6, s3, getDistance(s6, s3));

        boolean result;

        System.out.println("depth first ...");
        result = WeightedGraph.isPath(graph, s1, s2);
        System.out.println("s1 s2 " + result);
        result = WeightedGraph.isPath(graph, s1, s6);
        System.out.println("s1 s6 " + result);
        result = WeightedGraph.isPath(graph, s6, s5);
        System.out.println("s6 s5 " + result);
        result = WeightedGraph.isPath(graph, s6, s3);
        System.out.println("s6 s3 " + result);
        result = WeightedGraph.isPath(graph, s6, s1);
        System.out.println("s6 s1 " + result);

        System.out.println();
        System.out.println("breadth first ...");
        result = WeightedGraph.isPath(graph, s1, s2);
        System.out.println("s1 s2 " + result);
        result = WeightedGraph.isPath(graph, s1, s6);
        System.out.println("s1 s6 " + result);
        result = WeightedGraph.isPath(graph, s6, s5);
        System.out.println("s6 s5 " + result);
        result = WeightedGraph.isPath(graph, s6, s3);
        System.out.println("s6 s3 " + result);
        result = WeightedGraph.isPath(graph, s6, s1);
        System.out.println("s6 s1 " + result);
        System.out.println();
        WeightedGraph.shortestPaths(graph, s6);

        System.out.println();
        System.out.println();
        WeightedGraph.shortestPaths(graph, s4);

	}

	public static int getDistance(String from, String to){
		String jsonResponse = "";
        try {
        	jsonResponse = getHTML("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+from.replaceAll("\\s+","")+"&destinations="+to.replaceAll("\\s+","")+"&units=imperial&language=en-EN");
        } catch (Exception e){
        	System.out.println(e);
        }
        String distanceString = new JSONObject(jsonResponse).getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("text");
        Scanner getInt = new Scanner(distanceString);
        int distance = getInt.nextInt();

        String origin = new JSONObject(jsonResponse).getJSONArray("origin_addresses").getString(0);
        String destination = new JSONObject(jsonResponse).getJSONArray("destination_addresses").getString(0);

        System.out.println("A trip from "+ origin +" to "+ destination +" is " +distanceString+ ".");

		return distance;
	}

	public static String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      return result.toString();
   }
}