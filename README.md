# EC327 Final Project Spring '20 Build Instructions:
1. Download ZIP version of all files in the repository.
2. Open AndroidStudio and create a project with "Empty Activity".
3. Project name must be "MyApplication2". **lowercase or uppercase?
4. On Desktop, open the file "MyApplication2" and then unzip the ZIP file created in step 1. 
5. Move the following files into the following locations: 

(In MyApplication2 file) app > src > main > java > com > example > myapplication2 **lowercase of uppercase?**
- Move all .java files into this location

(In MyApplication2 file) app > src > main > res > layout 
- Move all .xml files EXCEPT colors.xml, strings.xml, and styles.xml into this location

(In MyApplication2 file) app > src > main > res > values 
- Move colors.xml, strings.xml, and styles.xml into this location

6. In the AndroidManifest.xml file, include exactly:

<activity android:name=".bmi"/>

activity android:name=".water"/

activity android:name=".calorie"/

activity android:name=".steps"/ **Do we still need this?**

NOTE: EACH LINE MUST BE ENCLOSED WITHIN A < *line* > 

7. Open AVD Manager and select Pixel 2 API 27
8. Press the green play button in the AVD under "Actions"
9. Wait for emulator to boot and select application. 
  
 
