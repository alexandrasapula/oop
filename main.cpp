#include <iostream>
#include <vector>
#include <variant>
#include <cmath>
#include <format>
#include <cstddef>

using namespace std;

using NumberVariant = variant<int, double, float, char, short, long>;

class NumberOperations 
{
public:
    void main() 
    {

        vector<NumberVariant> numberList = { 10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9 };

        numberList.push_back(23);
        numberList.push_back(3.57);
        numberList.push_back((char)4);
        numberList.push_back((short)32);
        numberList.push_back(40L);
        numberList.push_back(5.67f);

        cout << "All numbers: [";
        printNumbers(numberList);

        processNumbers(numberList);

        splitByType(numberList);

        vector<NumberVariant> initialNumberList = { 10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9 };
        extractIntegers(initialNumberList);
    }

    void printNumbers(const vector<NumberVariant>& numbers) 
    {
        for (const auto& num : numbers) 
        {
            visit([&](const auto& value) 
                {
                if constexpr (is_same_v<decay_t<decltype(value)>, char>) 
                {
                    cout << (int)value << " ";
                }
                else 
                {
                    cout << value << " ";
                }
                }, num);
        }
        cout << "]" << endl;
    }

    void processNumbers(const vector<NumberVariant>& numbers) 
    {
        vector<int> integers;
        vector<string> formattedDoubles;
        vector<int> roundedNumbers;

        for (const auto& num : numbers) 
        {
            visit([&](const auto& value) 
                {
                using T = decay_t<decltype(value)>;
                integers.push_back((int)value);
                formattedDoubles.push_back(to_string_with_precision(value, 2));
                roundedNumbers.push_back((int)round(value));
                }, num);
        }

        cout << "Integers: [";
        for (int val : integers) cout << val << " ";
        cout << "]" << endl;

        cout << "Doubles: [";
        for (const auto& val : formattedDoubles) cout << val << " ";
        cout << "]" << endl;

        cout << "Rounded numbers: [";
        for (int val : roundedNumbers) cout << val << " ";
        cout << "]" << endl;
    }

    void splitByType(const vector<NumberVariant>& numbers) 
    {
        vector<int> onlyIntegers;
        vector<double> onlyDoubles;
        vector<float> onlyFloats;
        vector<char> onlyBytes;

        for (const auto& num : numbers) 
        {
            if (const int* p = get_if<int>(&num)) 
            {
                onlyIntegers.push_back(*p);
            }
            else if (const double* p = get_if<double>(&num)) 
            {
                onlyDoubles.push_back(*p);
            }
            else if (const float* p = get_if<float>(&num)) 
            {
                onlyFloats.push_back(*p);
            }
            else if (const char* p = get_if<char>(&num)) 
            {
                onlyBytes.push_back(*p);
            }
        }

        cout << "Array of integers: [";
        for (int val : onlyIntegers) cout << val << " ";
        cout << "]" << endl;

        cout << "Array of doubles: [";
        for (double val : onlyDoubles) cout << val << " ";
        cout << "]" << endl;

        cout << "Array of floats: [";
        for (float val : onlyFloats) cout << val << " ";
        cout << "]" << endl;

        cout << "Array of bytes: [";
        for (char val : onlyBytes) cout << (int)val << " ";
        cout << "]" << endl;
    }

    void extractIntegers(const vector<NumberVariant>& numbers) 
    {
        vector<int> intNumbers;

        for (const auto& num : numbers) 
        {
            if (const int* p = get_if<int>(&num)) 
            {
                intNumbers.push_back(*p);
            }
        }

        cout << "Array of integers from the initial list: [";
        for (int val : intNumbers) cout << val << " ";
        cout << "]" << endl;
    }

    string to_string_with_precision(double value, int precision) 
    {
        return format("{:.{}f}", value, precision);
    };
};

int main() 
{
    NumberOperations operations;
    operations.main();
    return 0;
}
