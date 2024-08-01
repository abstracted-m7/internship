import tkinter as tk
from tkinter import messagebox
from datetime import datetime
import pandas as pd
import matplotlib.pyplot as plt

# Initialize the main application window
app = tk.Tk()
app.title("BMI Calculator")

# Create a DataFrame to store user data
data = pd.DataFrame(columns=['Date', 'Name', 'Weight', 'Height', 'BMI'])

# Function to calculate BMI
def calculate_bmi(weight, height):
    try:
        weight = float(weight)
        height = float(height) / 100  # convert height to meters
        bmi = weight / (height ** 2)
        return round(bmi, 2)
    except ValueError:
        messagebox.showerror("Invalid input", "Please enter valid numerical values for weight and height.")
        return None

# Function to save data
def save_data(name, weight, height, bmi):
    global data
    date = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    new_entry = {'Date': date, 'Name': name, 'Weight': weight, 'Height': height, 'BMI': bmi}
    data = data.append(new_entry, ignore_index=True)
    data.to_csv('bmi_data.csv', index=False)
    messagebox.showinfo("Success", "Data saved successfully!")

# Function to load data
def load_data():
    global data
    try:
        data = pd.read_csv('bmi_data.csv')
    except FileNotFoundError:
        pass

# Function to show historical data
def show_history(name):
    global data
    user_data = data[data['Name'] == name]
    if user_data.empty:
        messagebox.showinfo("No Data", "No historical data found for this user.")
    else:
        history_window = tk.Toplevel(app)
        history_window.title(f"{name}'s BMI History")
        history_text = tk.Text(history_window)
        history_text.pack()
        for index, row in user_data.iterrows():
            history_text.insert(tk.END, f"{row['Date']}: Weight: {row['Weight']} kg, Height: {row['Height']} cm, BMI: {row['BMI']}\n")

# Function to plot BMI trend
def plot_trend(name):
    global data
    user_data = data[data['Name'] == name]
    if user_data.empty:
        messagebox.showinfo("No Data", "No historical data found for this user.")
    else:
        plt.figure(figsize=(10, 5))
        plt.plot(pd.to_datetime(user_data['Date']), user_data['BMI'], marker='o', linestyle='-', color='b')
        plt.xlabel('Date')
        plt.ylabel('BMI')
        plt.title(f"{name}'s BMI Trend")
        plt.grid(True)
        plt.show()

# GUI layout
tk.Label(app, text="Name").grid(row=0, column=0, padx=10, pady=10)
tk.Label(app, text="Weight (kg)").grid(row=1, column=0, padx=10, pady=10)
tk.Label(app, text="Height (cm)").grid(row=2, column=0, padx=10, pady=10)

name_entry = tk.Entry(app)
weight_entry = tk.Entry(app)
height_entry = tk.Entry(app)

name_entry.grid(row=0, column=1, padx=10, pady=10)
weight_entry.grid(row=1, column=1, padx=10, pady=10)
height_entry.grid(row=2, column=1, padx=10, pady=10)

def on_calculate():
    name = name_entry.get()
    weight = weight_entry.get()
    height = height_entry.get()
    if not name or not weight or not height:
        messagebox.showerror("Input Error", "All fields are required.")
        return
    bmi = calculate_bmi(weight, height)
    if bmi:
        save_data(name, weight, height, bmi)
        messagebox.showinfo("BMI Result", f"Your BMI is {bmi}")

tk.Button(app, text="Calculate BMI", command=on_calculate).grid(row=3, column=0, columnspan=2, pady=20)

def on_show_history():
    name = name_entry.get()
    if not name:
        messagebox.showerror("Input Error", "Please enter a name to view history.")
        return
    show_history(name)

tk.Button(app, text="Show History", command=on_show_history).grid(row=4, column=0, columnspan=2, pady=10)

def on_plot_trend():
    name = name_entry.get()
    if not name:
        messagebox.showerror("Input Error", "Please enter a name to view trend.")
        return
    plot_trend(name)

tk.Button(app, text="Plot Trend", command=on_plot_trend).grid(row=5, column=0, columnspan=2, pady=10)

# Load data on startup
load_data()

# Run the application
app.mainloop()
