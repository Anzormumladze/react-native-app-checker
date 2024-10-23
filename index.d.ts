declare module 'react-native-app-checker' {
    export function isAppInstalled(packageName: string): Promise<boolean>;
  }
  