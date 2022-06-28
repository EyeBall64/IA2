public class DataBase {

    private int fieldLength;
    private String filename;
    private int rowWidth;

    public DataBase(String filename, int rowWidth, int fieldLength) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        this.fieldLength = fieldLength;//totalColWidth is not the total column width
    }

    public void appendRecord(String data) {
       /*String[] Separator = new String[2];
       Separator = data.split(",");
       if (Separator[0].length() != 10 )
        */

        if (data.length() != rowWidth){
            if (data.length() > rowWidth){
                System.out.println("Tried to write " + data + " to field width of " + rowWidth);

            }
            while (data.length() < rowWidth){
                data = data + " ";
            }

        }
        if (data.length() == 10){
            FileHandler.appendLine(filename, data);
        }

        // TODO: Pad the data to the correct record width
        // TODO: Report an error if the data is too long for the record

    }

    public void deleteRecord(int rowNumber) {
    }

    public String getRecord(int colIndex, int rowIndex) {
      return (FileHandler.readLineAt(filename, colIndex * 2 + colIndex * rowWidth + (rowIndex) * fieldLength)).substring(0,10);
    }

}