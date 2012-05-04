package cz.jfx.CodeAnalyser.Filters;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author Felix
 */
@XmlRootElement
public class Filter {

    private String extension;

    public Filter() {
    }

    public Filter(String extension) {
        this.extension = extension;
    }

    @XmlValue
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
