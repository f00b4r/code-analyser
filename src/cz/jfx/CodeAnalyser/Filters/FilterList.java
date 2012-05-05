package cz.jfx.CodeAnalyser.Filters;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felix
 */
@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilterList {

    @XmlAttribute
    private String name;
    @XmlElement(name = "extension")
    private ArrayList<Filter> extensions;

    public FilterList() {
        extensions = new ArrayList<>();
        name = null;
    }

    public FilterList(String name) {
        this.name = name;
        extensions = new ArrayList<>();
    }

    public FilterList(ArrayList<Filter> extensions) {
        this.extensions = extensions;
        name = null;
    }

    public FilterList(ArrayList<Filter> extensions, String name) {
        this.extensions = extensions;
        this.name = name;
    }

    public Filter[] getFiltersArray() {
        return extensions.toArray(new Filter[]{});
    }

    public ArrayList<Filter> getFilters() {
        return extensions;
    }

    public void addFilter(Filter f) {
        extensions.add(f);
    }

    public void removeFilter(Filter f) {
        extensions.remove(f);
    }

    public void removeFilter(String f) {
        extensions.remove(new Filter(f));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
