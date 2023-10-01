#include <iostream>
#include <cstdlib>
#include <ctime>

char board[3][3] = {
    {'1', '2', '3'},
    {'4', '5', '6'},
    {'7', '8', '9'}
};

char currentPlayer = 'X';

void displayBoard() {
    std::cout << "+---+---+---+" << std::endl;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            std::cout << "| " << board[i][j] << " ";
        }
        std::cout << "|" << std::endl;
        std::cout << "+---+---+---+" << std::endl;
    }
}

void enterMove() {
    int move;
    bool ok = false;
    while (!ok) {
        std::cout << "Enter your move enemy 😈 (1-9): ";
        std::cin >> move;
        ok = (move >= 1 && move <= 9);
        if (!ok) {
            std::cout << "Are you Blind 😑😑: repeat your input!" << std::endl;
            continue;
        }
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        char sign = board[row][col];
        ok = (sign != 'O' && sign != 'X');
        if (!ok) {
            std::cout << "Are you Blind 😑😑: repeat your input!" << std::endl;
            continue;
        }
        board[row][col] = 'O';
    }
}

void makeListOfFreeFields(int freeRows[], int freeCols[], int& freeCount) {
    freeCount = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] != 'O' && board[i][j] != 'X') {
                freeRows[freeCount] = i;
                freeCols[freeCount] = j;
                freeCount++;
            }
        }
    }
}

char victoryFor(char sgn) {
    if (sgn == 'X') {
        return 'm';
    } else if (sgn == 'O') {
        return 'y';
    } else {
        return 'n';
    }
}

void drawMove() {
    int freeRows[9], freeCols[9], freeCount;
    makeListOfFreeFields(freeRows, freeCols, freeCount);
    if (freeCount > 0) {
        int thisOne = rand() % freeCount;
        int row = freeRows[thisOne];
        int col = freeCols[thisOne];
        board[row][col] = 'X';
    }
}

int main() {
    srand(static_cast<unsigned>(time(nullptr)));
    displayBoard();
    int freeRows[9], freeCols[9], freeCount;
    makeListOfFreeFields(freeRows, freeCols, freeCount);
    bool humanTurn = true;
    char victor = 'n';

    while (freeCount > 0) {
        if (humanTurn) {
            enterMove();
            victor = victoryFor('O');
        } else {
            drawMove();
            victor = victoryFor('X');
        }
        displayBoard();
        if (victor != 'n') {
            break;
        }
        humanTurn = !humanTurn;
        makeListOfFreeFields(freeRows, freeCols, freeCount);
    }

    displayBoard();
    if (victor == 'y') {
        std::cout << "Shit 😣😥😡, You won!" << std::endl;
    } else if (victor == 'm') {
        std::cout << "U LOOSER: 😁😁😁😁I won" << std::endl;
    } else {
        std::cout << "Good Game: 🙌🙌 It's a Tie!" << std::endl;
    }

    return 0;
}
