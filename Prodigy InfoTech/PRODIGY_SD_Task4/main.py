#Game of Sudoku Solver
#=====================================

import tkinter as tk
from tkinter import messagebox

class SudokuSolver:
    def __init__(self, root):
        self.root = root
        self.root.title("Sudoku Solver")
        self.cells = [[None for _ in range(9)] for _ in range(9)]
        self.board = [[0] * 9 for _ in range(9)]
        self.create_widgets()

    def create_widgets(self):
        # Create a 9x9 grid of Entry widgets for Sudoku input
        for row in range(9):
            for col in range(9):
                entry = tk.Entry(self.root, width=5, justify="center", font=("Arial", 18), bg='white')
                entry.grid(row=row, column=col, padx=3, pady=3)
                entry.bind("<FocusOut>", self.validate_entry)
                self.cells[row][col] = entry

        # Add Solve button
        solve_button = tk.Button(self.root, text="Solve", command=self.solve)
        solve_button.grid(row=9, column=0, columnspan=9, pady=10)

    def validate_entry(self, event):
        entry = event.widget
        try:
            value = int(entry.get())
            if not (1 <= value <= 9):
                raise ValueError
            entry.config(bg='white')
        except ValueError:
            entry.delete(0, tk.END)
            entry.config(bg='lightcoral')

    def get_board(self):
        # Extract the board state from the grid of Entry widgets
        for row in range(9):
            for col in range(9):
                value = self.cells[row][col].get()
                self.board[row][col] = int(value) if value else 0

    def solve(self):
        self.get_board()
        if self.is_valid_board() and self.solve_sudoku(0, 0):
            self.display_solution()
        else:
            messagebox.showerror("Error", "No solution exists or invalid Sudoku input.")

    def is_valid_board(self):
        # Check if the current board is valid
        for row in range(9):
            for col in range(9):
                num = self.board[row][col]
                if num != 0:
                    self.board[row][col] = 0
                    if not self.is_safe(row, col, num):
                        self.board[row][col] = num
                        return False
                    self.board[row][col] = num
        return True

    def is_safe(self, row, col, num):
        # Check if 'num' is not in the current row, column, or 3x3 subgrid
        for i in range(9):
            if self.board[row][i] == num or self.board[i][col] == num:
                return False
        start_row, start_col = 3 * (row // 3), 3 * (col // 3)
        for i in range(3):
            for j in range(3):
                if self.board[start_row + i][start_col + j] == num:
                    return False
        return True

    def solve_sudoku(self, row, col):
        # Solve the Sudoku using backtracking
        if row == 9:
            return True
        if col == 9:
            return self.solve_sudoku(row + 1, 0)
        if self.board[row][col] != 0:
            return self.solve_sudoku(row, col + 1)
        
        for num in range(1, 10):
            if self.is_safe(row, col, num):
                self.board[row][col] = num
                if self.solve_sudoku(row, col + 1):
                    return True
                self.board[row][col] = 0
        return False

    def display_solution(self):
        # Display the solved Sudoku in the grid
        for row in range(9):
            for col in range(9):
                self.cells[row][col].delete(0, tk.END)
                self.cells[row][col].insert(0, str(self.board[row][col]))

if __name__ == "__main__":
    root = tk.Tk()
    SudokuSolver(root)
    root.mainloop()
