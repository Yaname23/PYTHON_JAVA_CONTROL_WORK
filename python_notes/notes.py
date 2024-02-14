import json
import os
from datetime import datetime

def create_note():
    timestamp = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    note_id = len(notes) + 1
    note_title = input("Введите название заметки ")
    note_text = input ("Введите текст ")

    note = {
        "id": note_id,
        "title": note_title,
        "text": note_text,
        "timestamp": timestamp
    }
    notes.append(note)
    save_notes()

    print("\nЗаметка создана")


def read_notes():
    for note in notes:
        print(f"\nЗаметка номер {note['id']}.-- {note['title']}-- \n    {note['text']} \nдата создания(изменения): {note['timestamp']} ")


def read_note():
    note_id = int(input("Введите номер заметки, которую нужно отобразить: "))
    note_index = -1
    for index, note in enumerate(notes):
        if note['id'] == note_id:
            note_index = index
            break
    if note_index != -1:
        print(f"\nЗаметка номер {note['id']}.-- {note['title']}-- \n    {note['text']} \nдата создания(изменения): {note['timestamp']} ")
    else:
        print("\nЗаметка с таким номером не найдена!!")

def edit_note():
    note_id = int(input("Введите номер заметки, которую хотите отредактировать: "))
    note_index = -1

    for index, note in enumerate(notes):
        if note['id'] == note_id:
            note_index = index
            break
    if note_index != -1:
        note_title = input("Введите новое название заметки: ")
        note_text = input("Введите новый текст заметки: ")

        notes[note_index]['title'] = note_title
        notes[note_index]['text'] = note_text
        notes[note_index]['timestamp'] = datetime.now().strftime('%Y-%m-%d %H:%M:%S')

        save_notes()

        print("\nИзменения сохранены!")
    else:
        print("\nЗаметка с таким номером не найдена!!")

def delete_note():
   note_id = int(input("Введите номер заметки, которую нужно удалить: \n"))
   note_index =-1

   for index, note in enumerate(notes):
      if note['id'] == note_id:
          note_index = index
          break

   if note_index != -1:
      del notes[note_index]
      save_notes()

      print("\nЗаметка удалена!!!")

   else:
      print("\nЗаметка с таким номером не найдена!!!")
def save_notes():
    with open("notes.json", "w") as file:
        json.dump(notes, file)



def load_notes():
    if os.path.exists("notes.json"):
        with open("notes.json", "r") as file:
            notes.extend(json.load(file))





notes = []

load_notes()

while True:
    print("\nВ программе ЗАМЕТКИ можно :  ")
    print("1. Создать новую заметку")
    print("2. Посмотреть все заметки")
    print("3. Посмотреть нужную заметку")
    print("4. Редактировать заметку")
    print("5. Удалить заметку")
    print("6. Выход")


    choice = input("Выберите цифру, соответствующую действию: ")

    if choice == "1":
        create_note()
    elif choice =="2":
        read_notes()
    elif choice == "3":
        read_note()
    elif choice == "4":
        edit_note()
    elif choice == "5":
        delete_note()
    elif choice == "6":
        break

    else:
        print("Некорректный выбор.Попробуйте снова.")


