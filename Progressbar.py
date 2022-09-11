import time

# Print iterations progress
def printProgressBar (iteration, total, prefix = '', suffix = '', decimals = 1, length = 100, fill = '█', printEnd = "\r"):
    """
    This function must be called in a loop to create terminal progress bar.
    @params:
        iteration   - Required  : current iteration (Int)
        total       - Required  : total iterations (Int)
        prefix      - Optional  : prefix string (String)
        suffix      - Optional  : suffix string (String)
        decimals    - Optional  : positive number of decimals in percent complete (Int)
        length      - Optional  : character length of bar (Int)
        fill        - Optional  : bar fill character (String)
        printEnd    - Optional  : end character (e.g. "\r", "\r\n") (String)
    """
    percent = ("{0:." + str(decimals) + "f}").format(100 * (iteration / float(total)))
    filledLength = int(length * iteration // total)
    bar = fill * filledLength + '─' * (length - filledLength)
    print(f'\r{prefix} |{bar}| {percent}% {suffix}', end = printEnd)
    # Print New Line on Complete
    if iteration == total: 
        print()


def mainProgressBar(gapTime, ProgressTitle, ProgressDescription): 
    """
    This function must be called in a loop to create terminal progress bar.
    @params:
        gaptime                 - Required  : time dedicated in each bar update (Int)
        ProgressTitle           - Required  : Progress Bar title (String)
        ProgressDescription     - Required  : Progress Bar description (String)
    """
    # A List of Items that will be usefull to waste some time during another update to the
    # progress bar. 
    items = list(range(0, 57))
    l = len(items)

    # Initial call to print 0% progress
    printProgressBar(0, l, prefix = ProgressTitle, suffix = ProgressDescription, length = 50)
    for i, item in enumerate(items):
        # Do stuff and waste some time...
        time.sleep(gapTime)
        # Update Progress Bar
        printProgressBar(i + 1, l, prefix = ProgressTitle, suffix = ProgressDescription, length = 50)


# Actual printable progress Bars
mainProgressBar(0.01,'Progress','Processing Data')


