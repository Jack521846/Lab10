import javax.swing.*;
import java.awt.*;

public class SortedListGUI
{
    private JTextField txtInput;
    private JTextField txtSearch;
    private JTextArea outputArea;

    private SortedList sortedList;

    public SortedListGUI()
    {
        sortedList = new SortedList();

        JFrame frame = new JFrame("Sorted List Binary Search");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input Controls
        JPanel topPanel = new JPanel();

        txtInput = new JTextField(10);
        JButton btnAdd = new JButton("Add");

        txtSearch = new JTextField(10);
        JButton btnSearch = new JButton("Search");

        topPanel.add(new JLabel("Add String"));
        topPanel.add(txtInput);
        topPanel.add(btnAdd);

        topPanel.add(new JLabel("Search String"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add Button Event
        btnAdd.addActionListener(e -> addString());

        // Search Button Event
        btnSearch.addActionListener(e -> searchString());

        frame.setVisible(true);
    }

    private void addString()
    {
        String item = txtInput.getText().trim();

        if(item.length() > 0)
        {
            sortedList.add(item);

            outputArea.setText(
                    "Current Sorted List\n\n" +
                            sortedList.display()
            );

            txtInput.setText("");
        }
    }

    private void searchString()
    {
        String target = txtSearch.getText().trim();

        if(target.length() == 0)
        {
            return;
        }

        int result = sortedList.binarySearch(target);

        if(result >= 0)
        {
            outputArea.append(
                    "\nFOUND: " +
                            target +
                            " at index " +
                            result +
                            "\n"
            );
        }
        else
        {
            int insertLocation = -(result + 1);

            outputArea.append(
                    "\nNOT FOUND: " +
                            target +
                            "\nWould be inserted at index " +
                            insertLocation +
                            "\n"
            );
        }

        txtSearch.setText("");
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
                new SortedListGUI());
    }
}