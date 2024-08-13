def calculate_compound_interest(principal, rate, time, n):
    """
    Calculate the compound interest.

    :param principal: The initial amount of money (principal)
    :param rate: The annual interest rate (in percentage)
    :param time: The time the money is invested or borrowed for (in years)
    :param n: The number of times that interest is compounded per year
    :return: The compound interest and total amount after the time period
    """
    rate_decimal = rate / 100

    amount = principal * (1 + rate_decimal / n) ** (n * time)

    compound_interest = amount - principal

    return compound_interest, amount

principal = float(input("Enter the principal amount: "))
rate = float(input("Enter the annual interest rate (in %): "))
time = float(input("Enter the time period (in years): "))
n = int(input("Enter the number of times interest is compounded per year: "))

compound_interest, amount = calculate_compound_interest(principal, rate, time, n)

print(f"\nCompound Interest: ${compound_interest:.2f}")
print(f"Total Amount after {time} years: ${amount:.2f}")
