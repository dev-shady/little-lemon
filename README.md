
# **Meta Android App Capstone Project**

### Note Before Testing App:
Food menu is retrieved from https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json. The 2nd and 3rd items in JSON response have image urls that give blank picture

### Keyfeatures:
1. Save user details in **shared preferences** for persistant storage.
2. Use **Ktor Client** lib to download network data.
3. Store network data in **Room** database for persistancy.
4. UI powered through **LiveData** from Room DB.
5. Use **Glide** to load remote images.
6. Filter Menu items using **Search Query**.
7. Filter Menu items using **category pills**.
         

### Screens:

1. **Onoarding Screen**:
   - User need to enter first name, last name and email address for registration.
   - Upon registration, User will be directed to Home screen.
   - The User Details will be stored in Shared Preferences.

2. **Home Screen**:
   - It contains Header, Hero, Category Pilss and Menu section.
   - **Header**: It contains brand logo and profile picture. Click on profile pic to navigate to Profile Screen.
   - **Hero**: It contains Resturant details i.e name, description and a photo and a search bar.
   - **Category pills**: It allows menu filtering based on category like starters, deserts etc.
   - **Menu**:
     -  It contains the full food menu retrieved from https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json
     -  **Note: 2nd and 3rd items in JSON response have image urls that give blank picture.**
     -  The data from URL is downloaded using **KTOR client library** and stored in **Room database**.
3. **Profile Screen**:
   - It shows the first name , last name and email of the User that was entered during onboarding.
   - It has logout button to clear user details. It takes you back to Onboarding screen.


## **Home:**


<img width="720" height="1280" alt="Screenshot_20260103_195038" src="https://github.com/user-attachments/assets/d9936e7a-e0eb-4e80-a8c5-de9bc63dfc39" />


## **Profile:**

<img width="720" height="1280" alt="Screenshot_20260103_195054" src="https://github.com/user-attachments/assets/5d74b6e9-761d-477b-bf3b-ae0daa6e4513" />


## **Onboarding:**


<img width="720" height="1280" alt="Screenshot_20260103_194957" src="https://github.com/user-attachments/assets/4e5f5de5-59a2-4db2-8903-d9c226c607a5" />


