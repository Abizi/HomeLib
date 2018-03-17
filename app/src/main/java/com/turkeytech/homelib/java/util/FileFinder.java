package com.turkeytech.homelib.java.util;

/**
 * How to use the code below. In the class that creates
 * the FileFinder object, create a Path object like so:
 * Path fileDirs = Paths.get(folderLocation**);
 * <p>
 * Create a FileFinder object passing in the search pattern.
 * Next, do this: Files.walkFileTree(fileDirs, finderObject);
 * <p>
 * Create an ArrayList object to store all paths matching the
 * pattern provided. Check whether any matches were find by finding
 * the size of the ArrayList object.
 * <p>
 * If the size of the array is greater than 0, loop through the ArrayList's
 * Path *objects to get the files that matched.
 * <p>
 * *This is by the way, remember path.toRealPath(LinkOption.NOFOLLOW_LINKS),
 * don't ask me anything.
 * <p>
 * **folderLocation is a string that contains the location of
 * the top level directory to be traversed.
 */
public class FileFinder
        /*extends SimpleFileVisitor<Path> {

    public ArrayList<Path> fileList = new ArrayList<>();
    private PathMatcher matcher;

    public FileFinder(String pattern) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path name = file.getFileName();

        if (matcher.matches(name))
            fileList.add(file);
        return FileVisitResult.CONTINUE;
    }*/ {

}
