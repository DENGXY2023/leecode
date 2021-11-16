package qusetions;
import java.util.ArrayList;
import java.util.List;

public class Q6_Convert {
    public String convert(String s, int numRows){
        if (numRows==1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for(int i =0;i<numRows;i++){
           rows.add(new StringBuilder());
        }
        int corRow =0;
        boolean goingDown = false;
        for(int i=0; i<s.length(); i++){
            rows.get(corRow).append(s.charAt(i));
            if(corRow==0||corRow==numRows-1){
                goingDown = !goingDown;
            }
            corRow += goingDown ? 1:-1;
        }
        StringBuilder sNew = new StringBuilder();
        for(int j=0; j<numRows; j++){
            sNew.append(rows.get(j));
        }
        return sNew.toString();
    }

    public static void main(String[] args) {
        Q6_Convert q6 = new Q6_Convert();
        System.out.println(q6.convert("PAYPALISHIRING",4));
    }

}
