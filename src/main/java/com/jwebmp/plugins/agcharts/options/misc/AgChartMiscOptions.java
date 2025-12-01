package com.jwebmp.plugins.agcharts.options.misc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Miscellaneous chart options for AG Charts 12.2.0.
 * 
 * Groups optional metadata and security-related settings:
 * - suppressFieldDotNotation: Disable dot notation in field paths
 * - styleNonce: CSP nonce for inline styles
 * - loadGoogleFonts: Auto-load Google Fonts
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartMiscOptions<J extends AgChartMiscOptions<J>> extends JavaScriptPart<J> {
    /** Suppress dot notation field access. */
    private Boolean suppressFieldDotNotation;
    
    /** Content Security Policy nonce for inline styles. */
    private String styleNonce;
    
    /** Auto-load Google Fonts. */
    private Boolean loadGoogleFonts;

    public Boolean getSuppressFieldDotNotation() {
        return suppressFieldDotNotation;
    }

    public @org.jspecify.annotations.NonNull J setSuppressFieldDotNotation(Boolean suppressFieldDotNotation) {
        this.suppressFieldDotNotation = suppressFieldDotNotation;
        return (J) this;
    }

    public String getStyleNonce() {
        return styleNonce;
    }

    public @org.jspecify.annotations.NonNull J setStyleNonce(String styleNonce) {
        this.styleNonce = styleNonce;
        return (J) this;
    }

    public Boolean getLoadGoogleFonts() {
        return loadGoogleFonts;
    }

    public @org.jspecify.annotations.NonNull J setLoadGoogleFonts(Boolean loadGoogleFonts) {
        this.loadGoogleFonts = loadGoogleFonts;
        return (J) this;
    }
}
