#!/bin/sh

if [ \! -x /usr/bin/svn -a \! -x /usr/local/bin/svn ]; then
	echo "Please install svn to use this utility"
	exit
fi

if [ "x$GWTPATH" = "x" ]; then
	echo "Please define GWTPATH=/path/to/gwt in environment"
	exit
fi

if [ -f $GWTPATH/gwt-dev-mac.jar ]; then
	JFLAGS=-XstartOnFirstThread
else
	JFLAGS=''
fi

VERSION=`head -4 .svn/entries | tail -1`
CLASSPATH="$GWTPATH/gwt-user.jar:$GWTPATH/gwt-dev.jar"

rm -rf dist
mkdir dist
svn export src/com dist/com
cd src/com
javac -cp "$CLASSPATH" -d ../../dist -s ../../dist `find . -name '*java'`
cd ../../dist
jar cf "raphaelgwt-r$VERSION.jar" com

