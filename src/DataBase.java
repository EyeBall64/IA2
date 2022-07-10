public class DataBase {

    private int fieldLength;
    private String filename;
    private int rowWidth;

    public DataBase(String filename, int rowWidth, int fieldLength) {
        this.filename = filename;
        this.rowWidth = rowWidth; //Total length of the line
        this.fieldLength = fieldLength; //Length of each field in a record
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
        if (data.length() == 15){
            FileHandler.appendLine(filename, data);
        }

    }

    public void deleteRecord(int rowNumber) {
    }

    public void editRecord(String data, int rowIndex, int colIndex){
        FileHandler.writeLineAt( filename,data,colIndex * fieldLength + rowIndex * (rowWidth + 2));
    }

    public String getRecord(int rowIndex, int colIndex) {
        String record = FileHandler.readLineAt(filename, (colIndex * fieldLength) + rowIndex * (rowWidth + 2));
        //System.out.println(":" + record);
        assert record != null;
        return (record).substring(0,fieldLength);
    }

}