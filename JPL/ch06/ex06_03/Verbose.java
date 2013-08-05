interface Verbose {
	enum verbosely{SILENT, TERSE, NORMAL, VERBOSE,}

	void setVerbosity(Verbosity level);
	Verbosity getVelbosity();

}
	