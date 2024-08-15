
# C -> F
def celsius_to_fahrenheit(celsius):
    return (celsius * 9/5) + 32

# C -> K
def celsius_to_kelvin(celsius):
    return celsius + 273.15

# F -> c
def fahrenheit_to_celsius(fahrenheit):
    return (fahrenheit - 32) * 5/9

# F -> K
def fahrenheit_to_kelvin(fahrenheit):
    return (fahrenheit - 32) * 5/9 + 273.15

# K -> c
def kelvin_to_celsius(kelvin):
    return kelvin - 273.15

# K-> F
def kelvin_to_fahrenheit(kelvin):
    return (kelvin - 273.15) * 9/5 + 32


#total managing function with the functionalites
def convert_temperature(value, unit):

    #for celsius to F & k
    if unit.lower() == 'c' or unit.lower() == 'celsius':
        fahrenheit = celsius_to_fahrenheit(value)
        kelvin = celsius_to_kelvin(value)

        print(f"{value}°C is equal to {fahrenheit:.2f}°F and {kelvin:.2f}K.")

    #For fahrenheit to C & K
    elif unit.lower() == 'f' or unit.lower() == 'fahrenheit':
        celsius = fahrenheit_to_celsius(value)
        kelvin = fahrenheit_to_kelvin(value)

        print(f"{value}°F is equal to {celsius:.2f}°C and {kelvin:.2f}K.")

    #For kelvin to C & F
    elif unit.lower() == 'k' or unit.lower() == 'kelvin':
        celsius = kelvin_to_celsius(value)
        fahrenheit = kelvin_to_fahrenheit(value)
        print(f"{value}K is equal to {celsius:.2f}°C and {fahrenheit:.2f}°F.")

    #if user's input not matched
    else:
        print("Invalid unit! \n Please use : \n 1. 'C' / Celsius \n 2. 'F' / Fahrenheit \n 3. 'K' / Kelvin.")


# declear the inputs 
def main():
    try:
        value = float(input("Enter the temperature value: "))

        choice = "\n C / Celsuis \n F / Fharenheit \n K / Kelvin"
        print(f"Units of measurement: {choice} ")

        unit = input("Enter the unit : ")

        convert_temperature(value, unit)

    except ValueError:
        print("Enter the valid number...!!")


#calling
if __name__ == "__main__":
    main()
