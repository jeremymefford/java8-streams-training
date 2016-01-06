import java.util.Collection;

/**
 * @author Jeremy Mefford
 * @since 1/5/16
 */
public class TestBean {

    private int id;

    private String category;

    private Collection<Integer> subIds;

    public TestBean(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public Collection<Integer> getSubIds() {
        return subIds;
    }

    public TestBean setSubIds(Collection<Integer> subIds) {
        this.subIds = subIds;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
