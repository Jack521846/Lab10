import java.util.ArrayList;

public class SortedList
{
    private ArrayList<String> list;

    public SortedList()
    {
        list = new ArrayList<>();
    }

    // Add a string in sorted order
    public void add(String value)
    {
        int position = binarySearch(value);

        if(position < 0)
        {
            position = -(position + 1);
        }

        list.add(position, value);
    }

    // Binary Search
    public int binarySearch(String target)
    {
        int low = 0;
        int high = list.size() - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            int compare = target.compareToIgnoreCase(list.get(mid));

            if(compare == 0)
            {
                return mid;
            }
            else if(compare < 0)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return -(low + 1);
    }

    // Display the entire list
    public String display()
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++)
        {
            sb.append(i)
                    .append(": ")
                    .append(list.get(i))
                    .append("\n");
        }

        return sb.toString();
    }
}