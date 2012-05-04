package cz.jfx.CodeAnalyser.Filters;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felix
 */
@XmlRootElement(name = "filters")
public class FilterImpl extends ArrayList<FilterList> {

    public FilterImpl() {
    }

    @XmlElement(name = "list")
    public ArrayList<FilterList> getFilters() {
        return this;
    }
}