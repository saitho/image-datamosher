# Image Datamosher

## What is this?

This tool was inspired by [Overwatch's Sombra ARG](https://wiki.gamedetectives.net/index.php?title=Sombra_ARG).
There was an image which was datamoshed. By computing the difference between the original image and the datamoshed image one could reveal a hidden text.

This tool enables you to create a such a datamoshed image based on a source image and a text.

## How does it work?

The tool will swap out random bits of the original image by the letters of the text you defined.
Creating the difference of the image (e.g. using the GNU diff command) and the original image will reveal the text again.

## How do I use it?

Input params:
- Input Image (required)
- Output Location (required)
- Text (optional; leaving it empty won't transform the image!)

image-datamosh.jar C:\\Path\\file.jpg C:\\out\\file_datamoshed.jpg "Hello World."
