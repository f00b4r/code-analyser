package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.Config.Config;
import cz.jfx.CodeAnalyser.Filters.Filter;
import cz.jfx.CodeAnalyser.Filters.FilterImpl;
import cz.jfx.CodeAnalyser.Filters.FilterList;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Felix
 */
public class FilterController {
    
    private static final Logger logger = Logger.getLogger(FilterController.class.getName());
    private FilterImpl filterLists = new FilterImpl();
    private AnalyserController context;
    
    public FilterController(AnalyserController context) {
        this.context = context;
        loadFilters();
    }
    
    public final void saveFilters() {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(FilterImpl.class);
            Marshaller m = jaxb.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(filterLists, new File(Config.getProperty("Settings.filters.file", "./filters.xml")));
        } catch (JAXBException ex) {
            logger.log(Level.WARNING, "Save JAXB filter list error: {0}", ex.getMessage());
        }
    }
    
    public final void loadFilters() {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(FilterImpl.class);
            Unmarshaller m = jaxb.createUnmarshaller();
            filterLists = (FilterImpl) m.unmarshal(new File(Config.getProperty("Settings.filters.file", "./filters.xml")));
        } catch (JAXBException ex) {
            ex.printStackTrace();
            logger.log(Level.WARNING, "Load JAXB filter list error: {0}", ex.getMessage());
        }
    }
    
    public FilterImpl getFilterLists() {
        return filterLists;
    }
    
    public FilterList createList(String name) {
        FilterList fl = new FilterList(name);
        filterLists.add(fl);
        return fl;
    }
}
