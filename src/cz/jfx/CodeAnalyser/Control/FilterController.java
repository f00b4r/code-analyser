package cz.jfx.CodeAnalyser.Control;

import cz.jfx.CodeAnalyser.Filters.Filter;
import cz.jfx.CodeAnalyser.Filters.FilterImpl;
import cz.jfx.CodeAnalyser.Filters.FilterList;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Felix
 */
public class FilterController {
    
    private static final Logger logger = Logger.getLogger(FilterController.class.getName());
    private FilterImpl filterLists = new FilterImpl();
    private AnalyserController context;
    
    public FilterController() {
    }
    
    public FilterController(AnalyserController context) {
        this.context = context;
        
        FilterList fl1 = new FilterList("xx");
        Filter f1 = new Filter("java");
        Filter f2 = new Filter("php");
        fl1.addFilter(f1);
        fl1.addFilter(f2);
        
        FilterList fl2 = new FilterList("cc");
        Filter f3 = new Filter("html");
        Filter f4 = new Filter("css");
        fl2.addFilter(f3);
        fl2.addFilter(f4);
        
        filterLists.add(fl1);
        filterLists.add(fl2);
        
        saveFilters();
    }
    
    public final void saveFilters() {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(FilterImpl.class);
            Marshaller m = jaxb.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(filterLists, new File("./list.xml"));
        } catch (JAXBException ex) {
            logger.log(Level.WARNING, "Error JAXB marshal filter list: {0}", ex.getMessage());
        }
    }
}
