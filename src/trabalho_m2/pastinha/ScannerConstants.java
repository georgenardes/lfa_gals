package gals;

public interface ScannerConstants
{
    int[] SCANNER_TABLE_INDEXES = 
    {
        0,
        21,
        25,
        25,
        25,
        25,
        25,
        35,
        35,
        36,
        37,
        38,
        39,
        40,
        41,
        42,
        43,
        44,
        45,
        46,
        47,
        48,
        49,
        49,
        49
    };

    int[][] SCANNER_TABLE = 
    {
        {9, 1},
        {10, 1},
        {13, 1},
        {32, 1},
        {42, 2},
        {43, 3},
        {45, 4},
        {47, 5},
        {48, 6},
        {49, 6},
        {50, 6},
        {51, 6},
        {52, 6},
        {53, 6},
        {54, 6},
        {55, 6},
        {56, 6},
        {57, 6},
        {94, 7},
        {99, 8},
        {105, 9},
        {9, 1},
        {10, 1},
        {13, 1},
        {32, 1},
        {48, 6},
        {49, 6},
        {50, 6},
        {51, 6},
        {52, 6},
        {53, 6},
        {54, 6},
        {55, 6},
        {56, 6},
        {57, 6},
        {97, 10},
        {109, 11},
        {112, 12},
        {112, 13},
        {116, 14},
        {114, 15},
        {117, 16},
        {105, 17},
        {114, 18},
        {109, 19},
        {97, 20},
        {105, 21},
        {114, 22},
        {114, 23}
    };

    int[] TOKEN_STATE = {-1,  0,  5,  3,  4,  6,  2,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9,  8 };

    String[] SCANNER_ERROR =
    {
        "Caractere nao esperado",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando capturar",
        "Erro identificando imprimir",
        "Erro identificando capturar",
        "Erro identificando imprimir",
        "Erro identificando capturar",
        "Erro identificando imprimir",
        "Erro identificando capturar",
        "Erro identificando imprimir",
        "Erro identificando capturar",
        "Erro identificando imprimir",
        "Erro identificando capturar",
        "Erro identificando imprimir",
        "Erro identificando capturar",
        "Erro identificando imprimir",
        "",
        ""
    };

}
