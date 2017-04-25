package firstProject;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ItemType {


}

class Paper {
   private int ID;
   private String name;
   private List<Integer> AuthorIDList;
   
   public Paper() {
	   AuthorIDList = new ArrayList<Integer>(); 
   }

   public Paper(int PaperID, String name,String AuthorStr) {
      this.ID = PaperID;
      this.name = name;
      AuthorIDList = new ArrayList<Integer>();
      setAuthorIDList(AuthorStr);
   }
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getID() {
      return ID;
   }

   public void setID(int id) {
      this.ID = id;
   }

   public List<Integer> getAuthorIDList() {
      return AuthorIDList;
   }

   public void setAuthorIDList(String authorStr) {
	  authorStr=authorStr.substring(0, authorStr.length()-1);
      StringTokenizer st = new StringTokenizer(authorStr,"|");
      while (st.hasMoreTokens()) {
         AuthorIDList.add(Integer.parseInt(st.nextToken()));
      }
   }
   
}

class Author implements Comparable<Author> {

   private int AuthorID;
   private String name;
   private List<Integer> paperIDList;
   
   public Author() {}
   
   public Author(int AuthorID, String name) {
      this.AuthorID = AuthorID;
      this.name = name;
      paperIDList = new ArrayList<Integer>(); 
   }

   public int getAuthorID() {
      return AuthorID;
   }

   public void setAuthorID(int authorID) {
      AuthorID = authorID;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<Integer> getPaperIDList() {
      return paperIDList;
   }

   public void addPapaerID(int paperID) {
      paperIDList.add(paperID);
   }

   public void setPapaerIDList(List<Integer> paperList) {
      this.paperIDList = paperList;
   }

   public int compareTo(Author other) {
      return paperIDList.size() - other.getPaperIDList().size();
   }
}