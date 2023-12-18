import csv

class ReadAndWriteData:
    def __init__(self, file_path):
        self.file_path = file_path
        self.data = self.read_data_from_csv()

    def read_data_from_csv(self):
        data_list = []
        with open(self.file_path, 'r') as file:
            csv_reader = csv.DictReader(file)
            for row in csv_reader:
                data_list.append(row)
        return data_list

    def display_data(self):
        print("Name\tSkillSet\tExperience")
        for row in self.data:
            print(f"{row['Name']}\t{row['SkillSet']}\t{row['Experience']}")


file_path = '../resources/data/exp_details.csv'
reader = ReadAndWriteData(file_path)
reader.display_data()