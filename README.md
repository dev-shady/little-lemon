
# **Meta Android App Capstone Project**

### KeyFeatures:

1. Onoarding Screen:
   - User need to enter first name, last name and email address for registration.
   - Upon registration, User will be directed to Home screen.
   - The User Details will be stored in Shared Preferences.

2. Home Screen:
   - It contains Header, Hero, Category Pilss and Menu section.
   - Header: It contains brand logo and profile picture
   - Hero: It contains Resturant details i.e name, description and a photo and a search bar.
   - Category pills: It allows menu filtering based on category like starters, deserts etc.
   - Menu:
     -  It contains the full food menu retrieved from https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json
     -  **Note: 2nd and 3rd items in JSON response have image urls that give blank picture.**
     -  The data from URL is downloaded using **KTOR client library** and stored in **Room database**.
3. Profile:
   - It shows the first name , last name and email of the User that was entered during onboarding.
   - It has logout button to clear user details. It takes you back to Onboarding screen.

Screens:

**Home:**

<img width="480" height="640" alt="Screenshot_20260103_174900" src="https://github.com/user-attachments/assets/6b57c69b-afaa-4596-8069-b12488082f15" />


**Profile:**

<img width="480" height="640" alt="Screenshot_20260103_175224" src="https://github.com/user-attachments/assets/54e9591b-3290-4ec4-9d53-3629fd10d54c" />

**Onboarding:**


<img width="480" height="640" alt="Screenshot_20260103_175232" src="https://github.com/user-attachments/assets/6269ad5e-2f54-4cb1-9a53-7ddc57694fac" />
