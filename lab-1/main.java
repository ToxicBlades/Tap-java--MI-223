import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Main
{
public static void main(String[] args){
String sentence = "";
int wordLenght = 0;
String myWord = "";
InputStreamReader is =
new InputStreamReader(System.in);
BufferedReader bis =
new BufferedReader(is);
try
{
System.out.println("Itrodu propoziţia: ");
sentence = bis.readLine();
System.out.println("Introdu lungimia cuvântului înlocuit");
wordLenght = Integer.parseInt(bis.readLine());
System.out.println("Introdu cuvîntul care trebue înlocuit");
myWord = bis.readLine();
}
catch (IOException e)
{
e.printStackTrace();
}
Text myText = new Text(myWord, sentence, wordLenght);
myText.changeSentence();
System.out.println("Propoziţia nouă" + myText.getSentence());
}}
class Text
{
private String mySentence;
private int charNumber;
private String wordToChange;
private String newSentence = "1.";
public Text(String wordToChange,
String mySentece, int charNumber) {
this.mySentence = mySentece;
this.wordToChange = wordToChange;
this.charNumber = charNumber;
}
public String getSentence()
{
return newSentence;
}
public void changeSentence()
{
int firstPos = 0;
int i;
for (i = 0; i < mySentence.length(); i++)
{
if (mySentence.charAt(i) == ' ')
{
if (i - firstPos == charNumber)
{
newSentence = newSentence.concat(wordToChange+" ");
firstPos = i+1;
}
else
{
newSentence = newSentence.concat
(mySentence.substring(firstPos, i+1));
firstPos=i+1;
}}
else if(i == mySentence.length()-1)
{
if (i - firstPos == charNumber)
{
newSentence = newSentence.concat(wordToChange+" ");
firstPos = i+1;
}
else
{
newSentence = newSentence.concat
(mySentence.substring(firstPos, i+1));
firstPos=i+1;
}}}}}