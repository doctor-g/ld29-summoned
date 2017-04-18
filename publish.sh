#!/bin/bash
DEST=/home/pvg/www/games/2014/ld29
echo Publishing to $DEST
cd html/target/dagon-html-1.0-SNAPSHOT
rsync -avz --exclude 'META-INF' --exclude 'WEB-INF' --delete . $DEST/
