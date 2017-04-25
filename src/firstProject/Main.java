package firstProject;


public class Main {

	public static void main(String[] args) {
		
		GraphManager gm = new GraphManager();
		
		gm.loadDB();
		gm.printGraph();
		
		/*
		DBManager dbm = new DBManager();
		
		for(int i=0; i<dbm.countRow(); i++)
		{
			dbm.loadAllData(i);
		}

		System.out.println("Count = " + dbm.countRow());
		*/
	}

}
