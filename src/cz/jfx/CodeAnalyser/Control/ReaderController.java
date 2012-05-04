package cz.jfx.CodeAnalyser.Control;

import java.util.logging.Logger;

/**
 *
 * @author Felix
 */
public class ReaderController {

    private AnalyserController context;
    private static final Logger logger = Logger.getLogger(ReaderController.class.getName());

    public ReaderController(AnalyserController context) {
        this.context = context;
    }
}
