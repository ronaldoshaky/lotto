import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class Lotto {


	public String[] normalLO = {"01", "03", "05",  "07", "09", "11", "13", "15", "17", "19", "21", "23", "25"};
	public String[] normalLE = {"02", "04", "06",  "08", "10", "12", "14", "16", "18", "20", "22", "24"};
	public String[] normalHO = {"27", "29", "31",  "33", "35", "37", "39", "41", "43", "45", "47", "49"};
	public String[] normalHE = {"26", "28", "30",  "32", "34", "36", "38", "40", "42", "44", "46", "48", "50"};
	
	public String[] luckyLO = {"01", "03", "05"};
	public String[] luckyLE = {"02", "04", "06"};
	public String[] luckyHO = {"07", "09", "11"};
	public String[] luckyHE = {"08", "10", "12"};
	
	public List<Profiler> myProfiledList;
	public List<OuterFrequency> myOuterFrequency;
	public List<OuterFrequency> myInnerFrequency;
	public List<String> nrmalLO;
	public List<String> nrmalLE;
	public List<String> nrmalHO;
	public List<String> nrmalHE;
	public List<String> lckyLO;
	public List<String> lckyLE;
	public List<String> lckyHO;
	public List<String> lckyHE;
	
	
	class OuterFrequency {
		public String basicString = "";
		public List<Integer> profileIDs = new ArrayList<Integer>();
		
		public void setBasicString(String basicString) {
			this.basicString = basicString;
		}
		
		public String getBasicString() {
			return this.basicString;
		}

		public void setProfileIDS(List<Integer> profileIDs) {
			this.profileIDs = profileIDs;
		}
		
		public List<Integer> getProfileIDS() {
			return this.profileIDs;
		}			
	}


	class Profiler {
		public int profileID = 0;
		public int NormalLO = 0;
		public int NormalHO = 0;
		public int NormalLE = 0;
		public int NormalHE = 0;
		public int LuckyLO = 0;
		public int LuckyHO = 0;
		public int LuckyLE = 0;
		public int LuckyHE = 0;
		public String[] numbers;
		public String theOverallString = "";
		public String theBasicString = "";
		public Date theDateOfTheDraw = null;
		public int theDrawNumber = 0;
		
		
		public void setNumbers(String[] numbers) {
			this.numbers = numbers;
		}
		
		public String[] getNumbers() {
			return this.numbers;
		}	

		public void setDrawNumber(int theDrawNumber) {
			this.theDrawNumber = theDrawNumber;
		}
		
		public int getDrawNumber() {
			return this.theDrawNumber;
		}			
		
		public void buildOverallString() {
			// 3O-2LO+1HO|2E-1LE+1HE|1O:1E-1LO+1LE+0HO+0HE
			// 0O-0LO+0HO|5E-4LE+1HE|0O:2E-0LO+1LE+0HO+1HE
			theOverallString = this.sendBasicString() + "=" + Integer.toString(NormalLO + NormalHO) + "O-" 
								+ Integer.toString(NormalLO) + "LO"       // NEED TO FINISH THIS TODO PUT IN DATE ALSO
								+ Integer.toString(NormalHO) + "HO|" 
								+ Integer.toString(NormalLE + NormalHE) + "E-"
								+ Integer.toString(NormalLE) + "LE"
								+ Integer.toString(NormalHE) + "HE|"
								+ Integer.toString(LuckyLO + LuckyHO) + "O:" + Integer.toString(LuckyLE + LuckyHE) + "E-"
								+ Integer.toString(LuckyLO) + "LO+"
								+ Integer.toString(LuckyLE) + "LE+"
								+ Integer.toString(LuckyHO) + "HO+"
								+ Integer.toString(LuckyHE) + "HE"
								;
		}
		
		public void buildBasicString() {
			// 3O|2E|1O:1E
			// 0O|5E|0O:2E
			theBasicString = Integer.toString(NormalLO + NormalHO) + "O|" 
								+ Integer.toString(NormalLE + NormalHE) + "E|"
								+ Integer.toString(LuckyLO + LuckyHO) + "O:" + Integer.toString(LuckyLE + LuckyHE) + "E"
								;
		}
		
		public String sendBasicString() {
			// 3O|2E|1O:1E
			// 0O|5E|0O:2E
			return Integer.toString(NormalLO + NormalHO) + "O|" 
								+ Integer.toString(NormalLE + NormalHE) + "E|"
								+ Integer.toString(LuckyLO + LuckyHO) + "O:" + Integer.toString(LuckyLE + LuckyHE) + "E"
								;
		}
		
		
		public String getOverallString() {
			return this.theOverallString;
		}
		
		public String getBasicString() {
			return this.theBasicString;
		}
		
		public int getProfileId() {
			return this.profileID;
		}
		public void setProfileId(int profileID) {
			this.profileID = profileID;
		}
		
		public Date getDate() {
			return this.theDateOfTheDraw;
		}
		public void setDate(Date theDateOfTheDraw) {
			this.theDateOfTheDraw = new GregorianCalendar(2014, 2, 11).getTime();
			

			this.theDateOfTheDraw = theDateOfTheDraw;
		}
		
		public int getNormalLO() {
			return this.NormalLO;
		}
		public void setNormalLO(int NormalLO) {
			this.NormalLO = NormalLO;
		}

		public int getNormalLE() {
			return this.NormalLE;
		}
		public void setNormalLE(int NormalLE) {
			this.NormalLE = NormalLE;
		}	

		public int getNormalHO() {
			return this.NormalHO;
		}
		public void setNormalHO(int NormalHO) {
			this.NormalHO = NormalHO;
		}

		public int getNormalHE() {
			return this.NormalHE;
		}
		public void setNormalHE(int NormalHE) {
			this.NormalHE = NormalHE;
		}

		public int getLuckyLO() {
			return this.LuckyLO;
		}
		public void setLuckyLO(int LuckyLO) {
			this.LuckyLO = LuckyLO;
		}

		public int getLuckyLE() {
			return this.LuckyLE;
		}
		public void setLuckyLE(int LuckyLE) {
			this.LuckyLE = LuckyLE;
		}	

		public int getLuckyHO() {
			return this.LuckyHO;
		}
		public void setLuckyHO(int LuckyHO) {
			this.LuckyHO = LuckyHO;
		}

		public int getLuckyHE() {
			return this.LuckyHE;
		}
		public void setLuckyHE(int LuckyHE) {
			this.LuckyHE = LuckyHE;
		}	
		
	}
	
	public Lotto () {
		myProfiledList = new ArrayList<Profiler>();
		myOuterFrequency = new ArrayList<OuterFrequency>();
		myInnerFrequency = new ArrayList<OuterFrequency>();
		
		// Compile the list of Odd and Even numbers for later analysis
		nrmalLO = Arrays.asList(normalLO);
		nrmalLE = Arrays.asList(normalLE);		
		nrmalHO = Arrays.asList(normalHO);
		nrmalHE = Arrays.asList(normalHE);
		
		lckyLO = Arrays.asList(luckyLO);
		lckyLE = Arrays.asList(luckyLE);
		lckyHO = Arrays.asList(luckyHO);
		lckyHE = Arrays.asList(luckyHE);
		
		String row = "";
		Profiler p;
		int i = 0;
		String[] data;
		String[] dateStuff;
		String[] numbers;
		Date holdingDate;
		String sDate1 = "";
		int theDrawNumber = 0;
		
		
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("lotto2.csv"));
			while ((row = csvReader.readLine()) != null) {
				p = new Profiler();
				p.setProfileId(i);
				
				//String[] data = row.split(",");
				// do something with the data
				//System.out.println(row); 13,18,20,23,30,2,4
				// spit the array - loop through it - if the item is in a specific array, take it's handle and attach it to its string
				// at the end should have a string which represents 
				// LOLOHOLEHE
				
				data = row.split(", "); // 15, Fri,21,May,2004, 15,29,37,39,49,04,09,   6712000,    1
				// this gives us ['15', "Fri,21,May,2004", "15,29,37,39,49,04,09", "", ""]
				// data[1] is the data for date purposes
				// data[2] is the data for numbers
				
				
				
				// BUILD THE DATE in JAVA
				// neeed to store the arrays for comparison do i?
				dateStuff = data[1].split(","); //["Fri","21","May","2004"]
				numbers = data[2].split(",");  //["15','29','37','39','49','04','09"]
				
				if (numbers.length < 7) {
					dateStuff = numbers; //["Fri","21","May","2004"]
					numbers = data[3].split(",");  //["15','29','37','39','49','04','09"]					
				}
				
				
				
				
				theDrawNumber = Integer.parseInt(data[0].trim());
				
				p.setNumbers(numbers);
				p.setDrawNumber(theDrawNumber);
				// 1290, Fri,31,Jan,2020, 13,18,20,23,30,02,04,  24336652,    0
				
				
				//sDate1 = dateStuff[3] + "/" + getMonthInStringFormat(dateStuff[2]) + "/" + dateStuff[1];
				//holdingDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
				
				
				//holdingDate = new GregorianCalendar(Integer.parseInt(dateStuff[3]), getMonthInIntFormat(dateStuff[2]), Integer.parseInt(dateStuff[1])).getTime();
				//System.out.println(Integer.parseInt(dateStuff[3]));
				//System.out.println(getMonthInStringFormat(dateStuff[2]));
				//System.out.println(Integer.parseInt(dateStuff[1]));
				//p.setDate(holdingDate);
				

				// okay take the first five integers, loop through them, convert as you go
				// is it in nrmalLO, ok it is, then update NormalLO ++ (get it then increment it then set it OBJECT stuff,) CONTINUE;
				//System.out.println("---------------->  " + Arrays.toString(numbers));
				for (int j = 0; j < 5; j++) {
					// numbers[j] in 
					if (nrmalLO.contains(numbers[j])) {
						int holder = p.getNormalLO();
						holder++;
						p.setNormalLO(holder);
						continue;
					}
					
					if (nrmalLE.contains(numbers[j])) {
						int holder = p.getNormalLE();
						holder++;
						p.setNormalLE(holder);
						continue;
					}
					
					if (nrmalHO.contains(numbers[j])) {
						int holder = p.getNormalHO();
						holder++;
						p.setNormalHO(holder);
						continue;
					}
					
					if (nrmalHE.contains(numbers[j])) {
						int holder = p.getNormalHE();
						holder++;
						p.setNormalHE(holder);
						continue;
					}
					
				}
				
				// okay take the last two integers, repeat the above process.
				for (int j = 5; j < 7; j++) {
					// numbers[j] in 
					if (lckyLO.contains(numbers[j])) {
						int holder = p.getLuckyLO();
						holder++;
						p.setLuckyLO(holder);
						continue;
					}
					
					if (lckyLE.contains(numbers[j])) {
						int holder = p.getLuckyLE();
						holder++;
						p.setLuckyLE(holder);
						continue;
					}
					
					if (lckyHO.contains(numbers[j])) {
						int holder = p.getLuckyHO();
						holder++;
						p.setLuckyHO(holder);
						continue;
					}
					
					if (lckyHE.contains(numbers[j])) {
						int holder = p.getLuckyHE();
						holder++;
						p.setLuckyHE(holder);
						continue;
					}
					
				}				
				
				// at the end contsruct basic and overall string 
				// ad it to myProfiledList
				p.buildBasicString();
				p.buildOverallString();
				myProfiledList.add(p);
				
				// lets test a printing!!!! DO THIS by breaking afterward yeah
				//System.out.println("Numbers: " + data[2]  );
				System.out.println("BASIC string: " + p.getBasicString()  );
				System.out.println("Overall String: " + p.getOverallString()  );
				System.out.println("Draw Number " + p.getDrawNumber()  );
				System.out.println("Numbers: " + Arrays.toString(p.getNumbers())  );
				System.out.println("");
				System.out.println("");
				
				i++;
				 // DONT FFFFFFFFFFFFFFFFFFFFFFORGET REEEEEMOVE THIS
				if (i > 50) {
					break;
				}
				
			}
			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
		}
		
		
		
		
		// now my profile list is built, what data do I want to coagulate. 
		// BREAKDOWN 1
		// I want to know what is the most frequent basic pattern string
		// among these, i want to know, whats the most frequent overall pattern string. 
		// among these most frequent pattenrs /string, whats the most frequent sub pattern of odd and even lucky numbers
		// OVERALL whats the most popular of the odd even patterns for the lucky numnbers is is 1o1e or 2o0e 
		
		// string and list of profile IDs attached to it, the count of this gives the frequency of the draw. 
		// 
		List<String> patterNs = new ArrayList<String>();
		List<Integer> holdingGroundForIds;
		OuterFrequency newOuterFrequency;
		String currentPattern = "";
		for (int k = 0; k < myProfiledList.size(); k++) {
			currentPattern = myProfiledList.get(k).getBasicString();
			holdingGroundForIds = new ArrayList<Integer>();
			//patterNs = new ArrayList<String>();
			
			if (patterNs.contains(currentPattern)) {
				// i'd have to iterate through myOuterFrequency and update the OuterFrequency. 
				
				for (int n = 0; n < myOuterFrequency.size(); n++) {
					if (currentPattern.equals(myOuterFrequency.get(n).getBasicString())) {
						holdingGroundForIds = myOuterFrequency.get(n).getProfileIDS();
						holdingGroundForIds.add(myProfiledList.get(k).getProfileId());
						myOuterFrequency.get(n).setProfileIDS(holdingGroundForIds);
					}
				}
			} else {
				// add it to the patterNs array 
				// and create the OuterFrequency for it
				// add it and this profile id to myOuterFrequency
				patterNs.add(currentPattern);
				newOuterFrequency = new OuterFrequency();
				newOuterFrequency.setBasicString(currentPattern);
				holdingGroundForIds = newOuterFrequency.getProfileIDS();
				holdingGroundForIds.add(myProfiledList.get(k).getProfileId());
				newOuterFrequency.setProfileIDS(holdingGroundForIds);
				myOuterFrequency.add(newOuterFrequency);
			}
		}
		
		for (int l=0; l < myOuterFrequency.size(); l++) {
			// print out 
			//System.out.println(myOuterFrequency.get(l).getBasicString() + " freq " + myOuterFrequency.get(l).getProfileIDS().size());
		}
		System.out.println("");
		
		
		// BREAKDOWN 2
		// OF THE ABOVE more frequent patterns, is there a more frequent combination of numbers for patterns such as 2LOHO, of those, 
		// WHEN WAS THE LAST ONE, WHAT ONE HASN'T APPEARED IN A WHILE
		// 
		patterNs = new ArrayList<String>();
		for (int k = 0; k < myProfiledList.size(); k++) {
			currentPattern = myProfiledList.get(k).getOverallString();
			holdingGroundForIds = new ArrayList<Integer>();
			//patterNs = new ArrayList<String>();
			
			if (patterNs.contains(currentPattern)) {
				// i'd have to iterate through myOuterFrequency and update the OuterFrequency. 
				
				for (int n = 0; n < myInnerFrequency.size(); n++) {
					if (currentPattern.equals(myInnerFrequency.get(n).getBasicString())) {
						holdingGroundForIds = myInnerFrequency.get(n).getProfileIDS();
						holdingGroundForIds.add(myProfiledList.get(k).getProfileId());
						myInnerFrequency.get(n).setProfileIDS(holdingGroundForIds);
					}
				}
			} else {
				// add it to the patterNs array 
				// and create the OuterFrequency for it
				// add it and this profile id to myOuterFrequency
				patterNs.add(currentPattern);
				newOuterFrequency = new OuterFrequency();
				newOuterFrequency.setBasicString(currentPattern);
				holdingGroundForIds = newOuterFrequency.getProfileIDS();
				holdingGroundForIds.add(myProfiledList.get(k).getProfileId());
				newOuterFrequency.setProfileIDS(holdingGroundForIds);
				myInnerFrequency.add(newOuterFrequency);
			}
		}
		
		
		//scan through innerFrequencyu and get the highest ProfileIDs size,
		// then use that to decrement and loop through the arraylist each time, to print out the items with a specific size in order
		int maxSize = 0;
		for (int l=0; l < myInnerFrequency.size(); l++) {
			if (myInnerFrequency.get(l).getProfileIDS().size() > maxSize) {
				maxSize = myInnerFrequency.get(l).getProfileIDS().size();
			}
		}

		for (int z = maxSize; z > 0; z--) {
			for (int l = 0; l < myInnerFrequency.size(); l++) {
				if (z ==  myInnerFrequency.get(l).getProfileIDS().size()) {
					//System.out.println(myInnerFrequency.get(l).getBasicString() + " freq " + myInnerFrequency.get(l).getProfileIDS().size());
				}
			}
		}
		
		/**for (int l=0; l < myInnerFrequency.size(); l++) {
			// print out 
			System.out.println(myInnerFrequency.get(l).getBasicString() + " freq " + myInnerFrequency.get(l).getProfileIDS().size());
		}*/	
		
		// BREAKDOWN 3
		// I want to cross reference popular numnbers against the above patterns. what's the most popular, whats the second most popular
		// 
		
		
		// of the , do THE MOST FREQUENT basic/oversll strings have an even distribution over all the LO,LE,HO,HE groups (FOR BOTH normal and lucky)?
		
		
		// what's the most popular basic and overall string that hasn't appeared in a while. 
		//												and that hasn't 
		
		
		// TODO: WHat's the most popular subpatern under 3O2E and whats the most popular subpatterun under 1O1E
		// for those subpatterns whats the most 
		
				
	}
	
	public String getMonthInStringFormat(String month) {
		String theMonth = "";
		switch (month) {
			case "Jan":
				theMonth = "01";
				break;
			case "Feb":
				theMonth = "02";
				break;
			case "Mar":
				theMonth = "03";
				break;
			case "Apr":
				theMonth = "04";
				break;
			case "May":
				theMonth = "05";
				break;
			case "Jun":
				theMonth = "06";
				break;
			case "Jul":
				theMonth = "07";
				break;
			case "Aug":
				theMonth = "08";
				break;
			case "Sep":
				theMonth = "09";
				break;
			case "Oct":
				theMonth = "10";
				break;
			case "Nov":
				theMonth = "11";
				break;
			case "Dec":
				theMonth = "12";
				break;				
				
		}
		return theMonth;
	}
	
	
	public static void main(String[] args) {
		new Lotto();				
	}

}
