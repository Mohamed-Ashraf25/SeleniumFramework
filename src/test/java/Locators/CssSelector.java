package Locators;

/*Css selector is a Query or Syntax used to search on element
Types
1-tag id     ->      tag#id   ---->  we can reduce it as below - > input#log   ->   #log
2-tag class  ->      tag.classname    ---->  we can reduce it as below - >  input.search-box  ->> .search-box
3-tag attribute  ->  tag[attibute=""value]      ------>driver.findelement(By.Cssselector("button[\"submit"\]"));
where button is attribute & submit is value ,,,be noted we but two \ \ because submit is wrap by two " "

4- tag class & attribute -> tag.classname[attribute="value"] ----->driver.findelement(By.Cssselector("input[name="button"]"));
*
if we have a sentance that contain spaces ,,we negelet the second part when copy it from inspect element page
*/
public class CssSelector {
}
