# from selenium import webdriver

# # Set up the driver
# driver = webdriver.Chrome('path/to/chromedriver')

# # Navigate to WhatsApp Web
# driver.get('https://web.whatsapp.com/')

# # Wait for the QR code to be scanned
# input('Scan the QR code and press Enter')

# # Send a message to a contact
# contact_name = 'John Doe'
# message = 'Hello, this is a spam message'

# # Find the contact by name
# x_arg = '//span[contains(@title,' + contact_name + ')]'
# contact = driver.find_element_by_xpath(x_arg)

# # Click on the contact to open the chat
# contact.click()

# # Wait for the textbox to be available
# input('Type your message and press Enter')

# # Find the textbox and send the message
# input_box = driver.find_element_by_class_name('_1Plpp')
# input_box.send_keys(message + '\n')


import pywhatkit as kt

phone_no = '+1234567890'
message = 'Hello, this is a test message.'
hour = 12
minutes = 0

kt.sendwhatmsg(phone_no, message, hour, minutes)