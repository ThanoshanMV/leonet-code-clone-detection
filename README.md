# LeONet: A Hybrid Deep Learning Approach for Code Clone Detection Using Abstract Syntax Tree Features

LeONet is a hybrid Deep Learning approach designed to enhance the detection of code clones in software systems.

## Features

- **Hybrid Architecture**: Integrates LeNet-5 and Oreo's Siamese network architecture to capture diverse code clone patterns.
- **Comprehensive Clone Detection**: Targets Type-1 (T1), Very-Strongly Type-3 (VST3), Strongly Type-3 (ST3), Moderately Type-3 (MT3), and Weakly Type-3/Type-4 (WT3/4) code clones.
- **AST Feature Extraction**

## Repository Structure

```
leonet-code-clone-detection/
├── bcb/                        # Instructions to setup BigCloneBench
├── feature-extractor-poc/      # Feature extraction
├── notebooks/                  # Jupyter notebooks for training and evaluation
├── pairs/                      # Method pairs for evaluation
├── scripts/                    # PostgreSQL scripts
└── README.md                   # Project overview
```

## Setup
All experiments were conducted on a system equipped with 8 GB RAM, an Intel Core i5-8250U processor, an NVIDIA GeForce MX130 GPU, and a 1 TB HDD.

The software environment included Python 3.9.18, TensorFlow 2.10.0, Keras 2.10.0, Pandas 2.2.3, Sklearn-compat 0.1.3 and Jupyter Notebook 7.3.2 running on Windows 11. This can be easily setup via [Anaconda](https://www.anaconda.com/)


## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or suggestions.

## Get in Touch

Thank you for your interest in LeONet! We are currently developing a series of enhanced models, with some specifically aimed at addressing the limitations of this work. We look forward to completing and sharing them in the near future.

If you have any questions, suggestions, or are interested in collaborating, please don’t hesitate to reach out — we’d be delighted to connect!
