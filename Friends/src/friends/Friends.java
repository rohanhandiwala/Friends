package friends;

import structures.Queue;
import structures.Stack;

import java.util.*;


public class Friends {

	/**
	 * Finds the shortest chain of people from p1 to p2.
	 * Chain is returned as a sequence of names starting with p1,
	 * and ending with p2. Each pair (n1,n2) of consecutive names in
	 * the returned chain is an edge in the graph.
	 * 
	 * @param g Graph for which shortest chain is to be found.
	 * @param p1 Person with whom the chain originates
	 * @param p2 Person at whom the chain terminates
	 * @return The shortest chain from p1 to p2. Null if there is no
	 *         path from p1 to p2
	 */
	
	private static int getIndex(String p1, Person[] frLists) {
		int i = 0;
		while (!p1.equals(frLists[i].name))
			i++;
		return i;
			
	}
	
	
		
	
	


		public static ArrayList<String> shortestChain(Graph g, String p1, String p2) {
			
			ArrayList<String> arr = new ArrayList<String>();
			arr.add(p1);
			Person[] frLists = g.members;
			int start = getIndex(p1, frLists), end = getIndex(p2, frLists);
			boolean[] visited = new boolean[frLists.length];
			Queue<Integer> queue = new Queue<>();
			//System.out.println(frLists.length);
			
			visited[start] = true;
			System.out.println("visiting:" + frLists[start].name);
			queue.enqueue(start);
			
			while(!queue.isEmpty()){
				int v = queue.dequeue();
				for(Friend fr=frLists[v].first; fr != null; fr = fr.next){
					int vnum = fr.fnum;
					if(!visited[vnum]){
						arr.add(frLists[vnum].name);
						System.out.println("visiting:"+frLists[vnum].name);
						visited[vnum] = true;
						queue.enqueue(vnum);
					}
				}
			}

			return arr;
		}
			
		

		/**
	 *
	 * Finds all cliques of students in a given school.
	 * 
	 * Returns an array list of array lists - each constituent array list contains
	 * the names of all students in a clique.
	 * 
	 * @param g Graph for which cliques are to be found.
	 * @param school Name of school
	 * @return Array list of clique array lists. Null if there is no student in the
	 *         given school
	 */
		
		 
		public static ArrayList<ArrayList<String>> cliques(Graph g, String school) {
			school=school.toLowerCase();
			boolean[] visit = new boolean[g.members.length];
			school=school.toLowerCase();
			ArrayList<ArrayList<String>> cliques = new ArrayList<ArrayList<String>>();
			ArrayList<String> clique;

			for(int i = 0; i < g.members.length; i++){
			if(visit[i]==false) {
			
				if(g.members[i].student && g.members[i].school.equals(school)){

			clique = sameSchool(g, i, visit);
			cliques.add(clique);


			}
			}
			}

			return cliques;

			}
	
	private static ArrayList<String> sameSchool(Graph g, int cliques, boolean[] visit){
		visit[cliques] = true;
        ArrayList<String> clique = new ArrayList<String>();
        clique.add(g.members[cliques].name);
        Person person;
        
        
        for (Friend friend = g.members[cliques].first; friend != null; friend = friend.next) {
        person = g.members[friend.fnum];

            if (!visit[friend.fnum]) {
            if(person.student && person.school.equals(g.members[cliques].school)){
            clique.addAll(sameSchool(g,friend.fnum,visit));
            }
            }
        }
        return clique;
    }
	/**
	 * Finds and returns all connectors in the graph.
	 * 
	 * @param g Graph for which connectors needs to be found.
	 * @return Names of all connectors. Null if there are no connectors.
	 */
	public static ArrayList<String> connectors(Graph g) {
		
		
		return null;
		
	}
	

}