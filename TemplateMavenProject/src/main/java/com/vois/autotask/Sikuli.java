package com.vois.autotask;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli {
	
Screen screen = new Screen();
	
	Pattern selectCell = new Pattern(System.getProperty("user.dir")+"//img//join_date.png");
	Pattern Data = new Pattern(System.getProperty("user.dir")+"//img//Data_tab.png");
	Pattern sort = new Pattern(System.getProperty("user.dir")+"//img//sort_tab.png");
	Pattern save = new Pattern(System.getProperty("user.dir")+"//img//save_btn.png");
	Pattern remove_duplicate = new Pattern (System.getProperty("user.dir")+"//img//remove_duplicate.png");
	Pattern unselectAll = new Pattern (System.getProperty("user.dir")+"//img//unselectAll.png");
	Pattern name = new Pattern (System.getProperty("user.dir")+"//img//name_cell.png");
	Pattern ok1 = new Pattern (System.getProperty("user.dir")+"//img//Ok1.png");
	Pattern ok2 = new Pattern (System.getProperty("user.dir")+"//img//Ok2.png");
	Pattern fileName = new Pattern(System.getProperty("user.dir")+"//img//FileName.png");
	Pattern openFile = new Pattern(System.getProperty("user.dir")+"//img//openFile.png");
	
	
	public void openExcelSheet () {
		
		App app = new App();
     	app.open(System.getProperty("user.dir")+"//ExcelSheet//Data.xlsx",20);
     	app.focus();
	}
	
	public void sortByJoinDate () throws FindFailed {
		
		screen.click(Data);
		screen.click(selectCell);
		screen.click(sort);
	}
	
	public void removeDuplicateInName () throws FindFailed {
		
		screen.click(remove_duplicate);
		screen.click(unselectAll);
		screen.doubleClick(name);
		screen.click(ok1);
		screen.click(ok2);
	}
	
	public void saveAndClose () throws Exception {
		
		screen.click(save);
		Thread.sleep(2000);
		screen.type(Key.F4, Key.ALT);
	}
	
	public void uploadFile (String path) throws FindFailed {
		
		System.out.println(path);
		screen.type(path);
		screen.click(openFile);
	}

}
