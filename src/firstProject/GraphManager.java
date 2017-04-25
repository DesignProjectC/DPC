package firstProject;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import firstProject.ItemType.*;

public class GraphManager{
	
	private DBManager dbm = new DBManager();
	
	private List<Author> authorList = new ArrayList<Author>();
	private List<Paper> paperList = new ArrayList<Paper>();

	class MyVertex { // good coding practice would have this as private
		private Author author;
		private int color;

		public MyVertex(Author author) {
			this.author = author;
		}

		public String toString() { // Always a good idea for debuging
			return author.getName(); // JUNG2 makes good use of these.
		}

		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}
		
	}

	class MyEdge {
		int numofCoauthorship;

		public MyEdge(int numofCoauthorship) {
			this.numofCoauthorship = numofCoauthorship;
		}

		public String toString() { // Always good for debugging
			return numofCoauthorship + "";
		}

	}

	class TopK {
		int numOfK;
		PriorityQueue<Author> minHeap = new PriorityQueue<Author>();

		public TopK(int numOfK) {
			this.numOfK = numOfK;
		}

		public void insert(Author author) {
			if (minHeap.size() < numOfK) {
				minHeap.add(author);
			} else {
				if (author.compareTo(minHeap.peek()) > 0) {
					minHeap.poll();
					minHeap.add(author);
				}
			}
		}

	}

	public void printGraph() {
		Graph<MyVertex, MyEdge> g = new UndirectedSparseMultigraph<MyVertex, MyEdge>();
		// Create some MyVertex objects to use as vertices
		
		List<MyVertex> vertexList = new ArrayList<MyVertex>();
		
		for(int i= 0; i < authorList.size();i++){
			MyVertex v = new MyVertex(authorList.get(i));
			g.addVertex(v);
			vertexList.add(v); // This

		}
		for(int i= 0; i < paperList.size();i++){
			if(paperList.get(i).getAuthorIDList().size()>1){
				int size = paperList.get(i).getAuthorIDList().size();
				for(int j=0;j<size-1;j++)
				{
					for(int k=j+1;k<size;k++)
						g.addEdge(new MyEdge(1), vertexList.get(paperList.get(i).getAuthorIDList().get(j)-1), vertexList.get(paperList.get(i).getAuthorIDList().get(k)-1), EdgeType.UNDIRECTED); // This
				}
						
				
			}
			
		}
		
		VisualizationImageServer vs = new VisualizationImageServer(new CircleLayout(g), new Dimension(700, 500));

		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		// vs.getRenderContext().setEdgeLabelTransformer(new
		// ToStringLabeller());

		JButton Button[] = new JButton[3];

		Button[0] = new JButton("전체 그래프 보기");
		Button[1] = new JButton("topK");
		Button[2] = new JButton("최단경로 찾기");

		JTextField textK = new JTextField(5);
		JTextField textStart = new JTextField(5);
		JTextField textEnd = new JTextField(5);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(Button[0]);
		buttonPanel.add(textK);
		buttonPanel.add(Button[1]);
		buttonPanel.add(textStart);
		buttonPanel.add(textEnd);
		buttonPanel.add(Button[2]);

		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(700, 600));
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setSize(700, 99);
		buttonPanel.setLocation(0, 500);
		frame.getContentPane().add(vs);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void printTopK() {
		Graph<MyVertex, MyEdge> g = new UndirectedSparseMultigraph<MyVertex, MyEdge>();
		// Create some MyVertex objects to use as vertices
		
		List<MyVertex> vertexList = new ArrayList<MyVertex>();
		
		for(int i= 0; i < authorList.size();i++){
			MyVertex v = new MyVertex(authorList.get(i));
			g.addVertex(v);
			vertexList.add(v); // This

		}
		for(int i= 0; i < paperList.size();i++){
			if(paperList.get(i).getAuthorIDList().size()>1){
				int size = paperList.get(i).getAuthorIDList().size();
				for(int j=0;j<size-1;j++)
				{
					for(int k=j+1;k<size;k++)
						g.addEdge(new MyEdge(1), vertexList.get(paperList.get(i).getAuthorIDList().get(j)-1), vertexList.get(paperList.get(i).getAuthorIDList().get(k)-1), EdgeType.UNDIRECTED); // This
				}
						
				
			}
			
		}
		
		VisualizationImageServer vs = new VisualizationImageServer(new CircleLayout(g), new Dimension(700, 500));

		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		// vs.getRenderContext().setEdgeLabelTransformer(new
		// ToStringLabeller());

		JButton Button[] = new JButton[3];

		Button[0] = new JButton("전체 그래프 보기");
		Button[1] = new JButton("topK");
		Button[2] = new JButton("최단경로 찾기");

		JTextField textK = new JTextField(5);
		JTextField textStart = new JTextField(5);
		JTextField textEnd = new JTextField(5);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(Button[0]);
		buttonPanel.add(textK);
		buttonPanel.add(Button[1]);
		buttonPanel.add(textStart);
		buttonPanel.add(textEnd);
		buttonPanel.add(Button[2]);

		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(700, 600));
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setSize(700, 99);
		buttonPanel.setLocation(0, 500);
		frame.getContentPane().add(vs);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public void loadDB()
	{
		int limit = dbm.countAuthorRow();
		for(int i=0; i<limit; i++)
		{
			authorList.add(dbm.loadAuthorData(i));
		}
		
		limit = dbm.countPaperRow();
		for(int i=0; i<limit; i++)
		{
			paperList.add(dbm.loadPaperData(i));
		}
		
	}

}
