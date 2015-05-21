# Getting Started #

Download the source distribution and extract in your project root, or download the jar and include it in your java classpath and/or Eclipse build path.

## Using RaphaelGWT in your project ##

To your module XML file, add:

```
    <inherits name='com.hydro4ge.raphaelgwt.RaphaelGWT' />
```


Add the following in the document head of your module HTML file:

```
    <script type="text/javascript" language="javascript" src="<module>/raphael-min.js"></script>
```

Since the RaphaelGWT module includes both the full and minified versions of the Raphael Javascript sources, you can trim the "-min" for debugging purposes.

## Viewing a Demo ##

Change into the `samples/<demo>` directory, define the environment variable `GWTPATH=/path/to/gwt-2.x`, and run `ant devmode` to see it in action.

**OR**, [sign up for a Pario trial](https://www.getpario.com/trial/signup/) to see RaphaelGWT used in a real commercial application.

## Getting Help ##
Do you have a question about RaphaelGWT?  Please post it in the [discussion group](http://groups.google.com/group/raphaelgwt).